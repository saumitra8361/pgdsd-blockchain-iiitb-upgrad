/*
 * spy-js - v2.0.0
 * http://spy-js.com
 * Copyright (c) 2013-2017 JetBrains - All Rights Reserved.
 *
 * This source code file is a part of spy-js plugin.
 */
var urlUtil=require("url"),_=_spy_js._;module.exports={normalizedUrl:function(a,b){if(!a)return a;_.str.startsWith(a,"http")||(a="http://"+a);var c=urlUtil.parse(a),d=c.protocol||"http:",e=c.port?":"+c.port:"";return d+"//"+c.hostname+e+(b?"/":c.path)},parse:function(a){var b=urlUtil.parse(a);return b.hrefNoHash=(b.href||"").replace(b.hash||"",""),b},join:function(a,b){return a+(_.str.endsWith(a,"/")?_.str.ltrim(b,"/"):b)}};