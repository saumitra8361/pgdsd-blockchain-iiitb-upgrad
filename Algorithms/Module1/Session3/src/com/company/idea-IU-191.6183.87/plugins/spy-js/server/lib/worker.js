/*
 * spy-js - v2.0.0
 * http://spy-js.com
 * Copyright (c) 2013-2017 JetBrains - All Rights Reserved.
 *
 * This source code file is a part of spy-js plugin.
 */
var ins=require("./instrument");process.on("message",function(a){try{var b=ins.run(a.code,{file:a.file,fileId:a.fileId,prettify:a.prettify,compact:a.compact,insertExpressionEvaluators:a.insertExpressionEvaluators,sourceMap:a.sourceMap});process.send({instrumentedCode:b.code,originalCode:b.originalCode,map:b.map,minRatio:b.minRatio,time:b.time})}catch(a){process.send({error:{message:a&&a.message,stack:a&&a.stack}})}}),process.send("READY");