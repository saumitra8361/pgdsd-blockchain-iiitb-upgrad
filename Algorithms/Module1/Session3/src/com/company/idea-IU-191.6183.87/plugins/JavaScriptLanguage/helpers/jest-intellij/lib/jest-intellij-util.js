const Tree = require('../../base-test-reporter/intellij-tree');
const util = require('../../base-test-reporter/intellij-util');
const path = require('path');
const processStdoutWrite = process.stdout.write.bind(process.stdout);
const processStderrWrite = process.stderr.write.bind(process.stderr);

function addTestFileNode(tree, testFilePath) {
  return tree.root.addTestSuiteChild(path.basename(testFilePath), 'file', testFilePath);
}

function reportTestFileResults(testFileNode, testResultsPerTestFile, withSpecResults) {
  const testFilePath = testResultsPerTestFile.testFilePath;
  const testResults = testResultsPerTestFile.testResults;
  if (typeof testResultsPerTestFile.failureMessage === 'string' && !(Array.isArray(testResults) && testResults.length > 0)) {
    const errorNode = testFileNode.addTestChild('Error', 'test', null);
    errorNode.setOutcome(Tree.TestOutcome.ERROR, null, testResultsPerTestFile.failureMessage, null, null, null, null, null);
    errorNode.start();
    errorNode.finish(false);
  }
  else if (withSpecResults) {
    reportSpecResults(testFileNode, testFilePath, testResults);
  }
  testFileNode.finish(false);
}

function reportSpecResults(testFileNode, testFilePath, testResults) {
  testResults.forEach(function (testResult) {
    const outcome = getOutcome(testResult.status);
    if (outcome === Tree.TestOutcome.SKIPPED) {
      return;
    }
    let currentParentNode = testFileNode;
    testResult.ancestorTitles.forEach(function (suiteTitle) {
      let childSuiteNode = currentParentNode.findChildNodeByName(suiteTitle);
      if (!(childSuiteNode && typeof childSuiteNode.addTestChild === 'function')) {
        const suiteLocationPath = getLocationPath(currentParentNode, suiteTitle, testFileNode, testFilePath);
        childSuiteNode = currentParentNode.addTestSuiteChild(suiteTitle, 'suite', suiteLocationPath);
        childSuiteNode.start();
      }
      currentParentNode = childSuiteNode;
    });
    const testLocationPath = getLocationPath(currentParentNode, testResult.title, testFileNode, testFilePath);
    const specNode = currentParentNode.addTestChild(testResult.title, 'test', testLocationPath);
    let failureMessage, failureDetails;
    if (testResult.failureMessages.length > 0) {
      failureMessage = '';
      failureDetails = testResult.failureMessages[0];
    }
    specNode.start();
    specNode.setOutcome(outcome, testResult.duration, failureMessage, failureDetails, null, null, null, null);
    specNode.finish(false);
  });
  testFileNode.children.forEach(function (childNode) {
    childNode.finishIfStarted();
  });
}

/**
 * @param {TestSuiteNode} parentNode
 * @param {string} nodeName
 * @param {TestSuiteNode} testFileNode
 * @param {string} testFilePath
 * @static
 */
function getLocationPath(parentNode, nodeName, testFileNode, testFilePath) {
  let names = [nodeName], n = parentNode;
  while (n !== testFileNode) {
    names.push(n.name);
    n = n.parent;
  }
  names.push(testFilePath || '');
  names.reverse();
  return util.joinList(names, 0, names.length, '.');
}

/**
 * @param {string} status
 * @returns {TestOutcome}
 */
function getOutcome(status) {
  if (status === 'passed') {
    return Tree.TestOutcome.SUCCESS;
  }
  if (status === 'pending' || status === 'disabled') {
    return Tree.TestOutcome.SKIPPED;
  }
  return Tree.TestOutcome.FAILED;
}

function warn(message) {
  const str = 'WARN - IDE integration: ' + message + '\n';
  try {
    processStderrWrite(str);
  }
  catch (ex) {
    try {
      processStdoutWrite(str);
    }
    catch (ex) {
      // do nothing
    }
  }
}

function safeFn(fn) {
  return function () {
    try {
      return fn.apply(this, arguments);
    } catch (ex) {
      warn(ex.message + '\n' + ex.stack);
    }
  };
}

exports.addTestFileNode = addTestFileNode;
exports.reportTestFileResults = reportTestFileResults;
exports.warn = warn;
exports.safeFn = safeFn;
exports.getLocationPath = getLocationPath;

exports.createGlobals = function (originalSetupTestFrameworkScriptFile) {
  const globals = {};
  if (originalSetupTestFrameworkScriptFile) {
    globals._JB_INTELLIJ_ORIGINAL_SETUP_TEST_FRAMEWORK_SCRIPT_FILE = originalSetupTestFrameworkScriptFile;
  }
  return globals;
};
exports.getOriginalSetupTestFrameworkScriptFile = function () {
  if (typeof _JB_INTELLIJ_ORIGINAL_SETUP_TEST_FRAMEWORK_SCRIPT_FILE !== 'undefined') {
    return _JB_INTELLIJ_ORIGINAL_SETUP_TEST_FRAMEWORK_SCRIPT_FILE;
  }
};
exports.JASMINE_REPORTER_DISABLED = '_JB_INTELLIJ_JASMINE_REPORTER_DISABLED';
