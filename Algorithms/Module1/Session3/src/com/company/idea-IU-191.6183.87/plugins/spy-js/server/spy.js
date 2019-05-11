/*
 * spy-js - v2.0.0
 * http://spy-js.com
 * Copyright (c) 2013-2017 JetBrains - All Rights Reserved.
 *
 * This source code file is a part of spy-js plugin.
 */
require("./lib/global");var app=require("./lib/app"),program=require("commander");program.option("-h, --host <host>","specify host").option("-p, --port <port>","specify port").option("-s, --ssl <ssl>","specify SSL proxy port").parse(process.argv);var options={};program.host&&(options.host=program.host),program.port&&(options.port=program.port),require("semver").gt(process.versions.node,"0.10.5")?app.start(options):console.error("Node.js version that you are running ("+process.versions.node+") is less than minimal required for spy-js (v0.10.6). You can download minimal required or newer version from http://nodejs.org/dist/ and upgrade your main node.js version or install and use the downloaded version just for spy-js side by side with your main one.");