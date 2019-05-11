import {CLIEngine, Linter} from "eslint";

class ESLintResponse {
    request_seq: number;
    command: string;
    body?: any;
    error?: string;
    isNoConfigFile: boolean
}

export interface EslintPluginState extends PluginState {
    readonly eslintPackagePath: string;
    readonly additionalRootDirectory?: string;
    readonly filterSource: boolean | null;
}

enum FileKind {
    js = "js",
    ts = "ts",
    html = "html",
    vue = "vue",
}

interface ESLintRequest {
    /**
     * Unique id of the message
     */
    readonly seq: number;

    /**
     * Message type (usually it is "request")
     */
    readonly type: string;

    /**
     * Id of the command
     */
    readonly command: string;

    /**
     * Additional arguments
     */
    readonly arguments: RequestArguments;
}

interface RequestArguments {
    /**
     * .eslintignore file path
     */
    readonly ignoreFilePath: string;
    /**
     * Absolute path for the file to check
     */
    readonly fileName: string;

    /**
     * Absolute config path
     */
    readonly configPath: string | null;
    readonly content: string;
    readonly extraOptions: string | null;
    readonly fileKind: FileKind
}

export class ESLintPlugin implements LanguagePlugin {
    private static readonly GetErrors: string = "GetErrors";
    private static readonly FixErrors: string = "FixErrors";
    private readonly filterSource: boolean | null;
    private readonly additionalRulesDirectory?: string;
    private readonly options: any;
    private readonly cliEngine: any;
    private readonly basicPath: string;

    constructor(state: EslintPluginState) {
        this.filterSource = state.filterSource;
        this.additionalRulesDirectory = state.additionalRootDirectory;
        const packagePath = normalizePath(state.eslintPackagePath);
        this.options = require(packagePath + "lib/options");
        this.cliEngine = require(packagePath + "lib/cli-engine");
    }

    onMessage(p: string, writer: MessageWriter): void {
        const request: ESLintRequest = JSON.parse(p);
        let response: ESLintResponse = new ESLintResponse();
        response.request_seq = request.seq;
        response.command = request.command;
        try {
            let body: any;
            if (request.command === ESLintPlugin.GetErrors) {
                body = this.getErrors(request.arguments);
            } else if (request.command === ESLintPlugin.FixErrors) {
                body = this.fixErrors(request.arguments);
            }
            if (this.filterSource == null || this.filterSource) {
                ESLintPlugin.filterSourceOut(body);
            }
            response.body = body;
        } catch (e) {
            response.isNoConfigFile = "no-config-found" === e.messageTemplate
                || (e.message && containsString(e.message.toString(), "No ESLint configuration found"));
            response.error = e.toString() + "\n\n" + e.stack;
        }
        writer.write(JSON.stringify(response));
    }

    private static filterSourceOut(body: any) {
        for (let i = 0; i < body.length; i++) {
            let elem = body[i];
            if (elem != null) {
                if (elem.source != null) elem.source = "";
                if (elem.messages != null) {
                    for (let j = 0; j < elem.messages.length; j++) {
                        let message = elem.messages[j];
                        if (message.source != null) message.source = "";
                    }
                }
            }
        }
    }

    private getErrors(getErrorsArguments: RequestArguments): CLIEngine.LintReport {
        return this.invokeESLint(getErrorsArguments)
    }

    private fixErrors(fixErrorsArguments: RequestArguments): CLIEngine.LintReport {
        return this.invokeESLint(fixErrorsArguments, {fix: true})
    }

    private invokeESLint(requestArguments: RequestArguments, additionalOptions: CLIEngine.Options = {}): CLIEngine.LintReport {
        const parsedCommandLineOptions = translateOptions(this.options.parse(requestArguments.extraOptions || ""));
        const options: CLIEngine.Options = {...parsedCommandLineOptions, ...additionalOptions};
        options.ignorePath = requestArguments.ignoreFilePath;
        if (requestArguments.configPath != null) {
            options.configFile = requestArguments.configPath;
        }
        if (this.additionalRulesDirectory != null && this.additionalRulesDirectory.length > 0) {
            if (options.rulePaths == null) {
                options.rulePaths = [this.additionalRulesDirectory]
            } else {
                options.rulePaths.push(this.additionalRulesDirectory);
            }
        }
        const cliEngine: CLIEngine = new this.cliEngine(options);
        const config = cliEngine.getConfigForFile(requestArguments.fileName);
        if (!isFileKindAcceptedByConfig(config, requestArguments.fileKind) || cliEngine.isPathIgnored(requestArguments.fileName)) {
            return {results: [], warningCount: 0, fixableWarningCount: 0, fixableErrorCount: 0, errorCount: 0};
        }
        return cliEngine.executeOnText(requestArguments.content, requestArguments.fileName);
    }
}

function isFileKindAcceptedByConfig(config: Linter.Config, fileKind: FileKind): boolean {
    const plugins: string[] | null | undefined = (<any>config).plugins;

    function hasPlugin(toCheck: string): boolean {
        return plugins != null && plugins
            .filter(value => value == toCheck || value == "eslint-plugin-" + toCheck).length > 0;
    }

    function hasParser(parser: string): boolean {
        return (config.parser != null && containsString(normalizePath(config.parser), parser))
          || (config.parserOptions != null && parser == config.parserOptions["parser"])
    }

    if (fileKind === FileKind.ts) {
        return hasPlugin("typescript") || hasParser("babel-eslint") || hasParser("typescript-eslint-parser")
            || hasParser("@typescript-eslint/parser")
    }
    if (fileKind === FileKind.html) {
        return hasPlugin("html")
    }
    if (fileKind === FileKind.vue) {
        return (
            //eslint-plugin-html used to process .vue files prior to v5
            hasPlugin("html") ||
            //eslint-plugin-vue in plugins used to be enough to process .vue files prior to v3
            hasPlugin("vue") ||
            hasParser("vue-eslint-parser")
        )
    }
    return true;
}

function containsString(src: string | null | undefined, toFind: string): boolean {
    return src != null && src.indexOf(toFind) >= 0
}

function normalizePath(eslintPackagePath: string): string {
    if (eslintPackagePath.charAt(eslintPackagePath.length - 1) !== '/' &&
        eslintPackagePath.charAt(eslintPackagePath.length - 1) !== '\\') {
        eslintPackagePath = eslintPackagePath + '/';
    }
    return eslintPackagePath.split("\\").join("/");
}

// taken from private part of eslint(lib/cli.js), we need it here
/**
 * Translates the CLI options into the options expected by the CLIEngine.
 * @param {Object} cliOptions The CLI options to translate.
 * @returns {CLIEngine.Options} The options object for the CLIEngine.
 * @private
 */
function translateOptions(cliOptions: any): CLIEngine.Options {
    return {
        envs: cliOptions.env,
        extensions: cliOptions.ext,
        rules: cliOptions.rule,
        plugins: cliOptions.plugin,
        globals: cliOptions.global,
        ignore: cliOptions.ignore,
        ignorePath: cliOptions.ignorePath,
        ignorePattern: cliOptions.ignorePattern,
        configFile: cliOptions.config,
        rulePaths: cliOptions.rulesdir,
        useEslintrc: cliOptions.eslintrc,
        parser: cliOptions.parser,
        parserOptions: cliOptions.parserOptions,
        cache: cliOptions.cache,
        cacheFile: cliOptions.cacheFile,
        cacheLocation: cliOptions.cacheLocation,
        allowInlineConfig: cliOptions.inlineConfig,
        reportUnusedDisableDirectives: cliOptions.reportUnusedDisableDirectives
    };
}
