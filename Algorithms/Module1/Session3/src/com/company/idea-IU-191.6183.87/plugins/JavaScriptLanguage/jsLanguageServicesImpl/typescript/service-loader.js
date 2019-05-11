"use strict";
exports.__esModule = true;
var toReplace = "ioSession.listen()";
var replacement = "//ioSession.listen()";
/**
 * Provide service for old & new integration (ts-complier-host-impl)
 */
function getService(serverFolderPath, acceptServices) {
    if (serverFolderPath == null) {
        throw new Error('Service file is empty');
    }
    var fs = require('fs');
    var data = getFilePathIfExists(fs, serverFolderPath, acceptServices);
    if (!data) {
        throw new Error('Cannot find tsserverlibrary.js or tsserver.js file');
    }
    var filePath = data.path;
    var context = null;
    var vm = require('vm');
    context = createContext(context, vm);
    vm.runInNewContext(data.data, context);
    if (!context || !context.ts) {
        throw new Error('Cannot find tsserver implementation in the file ' + filePath);
    }
    return {
        context: context,
        serverFilePath: filePath
    };
}
exports.getService = getService;
function getFilePathIfExists(fs, serverFolderPath, acceptServices) {
    {
        var pathToServicesFile = serverFolderPath + "tsserverlibrary.js";
        if (fs.existsSync(pathToServicesFile)) {
            return {
                data: fs.readFileSync(pathToServicesFile, 'utf-8'),
                path: pathToServicesFile
            };
        }
    }
    {
        var pathToServerFile = serverFolderPath + "tsserver.js";
        if (fs.existsSync(pathToServerFile)) {
            var fileData = fs.readFileSync(pathToServerFile, 'utf-8');
            return {
                data: fileData.replace(toReplace, replacement),
                path: pathToServerFile
            };
        }
    }
    {
        if (acceptServices) {
            var pathToServicesFile = serverFolderPath + "typescriptServices.js";
            if (fs.existsSync(pathToServicesFile)) {
                return {
                    data: fs.readFileSync(pathToServicesFile, 'utf-8'),
                    path: pathToServicesFile
                };
            }
        }
    }
    return null;
}
function createContext(context, vm) {
    context = vm.createContext();
    context.module = module;
    context.require = require;
    context.process = process;
    context.__dirname = __dirname;
    context.__filename = __filename;
    context.Buffer = Buffer;
    context.setTimeout = setTimeout;
    context.setInterval = setInterval;
    context.setInterval = setInterval;
    context.setImmediate = setImmediate;
    context.global = global;
    context.console = console;
    context.clearTimeout = clearTimeout;
    context.clearInterval = clearInterval;
    context.clearImmediate = clearImmediate;
    context.exports = exports;
    return context;
}
