"use strict";
exports.__esModule = true;
var eslint_plugin_1 = require("./eslint-plugin");
var ESLintPluginFactory = /** @class */ (function () {
    function ESLintPluginFactory() {
    }
    ESLintPluginFactory.prototype.create = function (state) {
        return { languagePlugin: new eslint_plugin_1.ESLintPlugin(state) };
    };
    return ESLintPluginFactory;
}());
var factory = new ESLintPluginFactory();
exports.factory = factory;
//# sourceMappingURL=eslint-plugin-provider.js.map