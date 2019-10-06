var config = {
  mode: 'development',
  resolve: {
    modules: [
      "node_modules"
    ]
  },
  plugins: [],
  module: {
    rules: []
  }
};

// entry
if (!config.entry) config.entry = [];
config.entry.push("/home/kostya05983/Projects/Blog/build/js/packages/Blog/kotlin/Blog.js");
config.output = {
    path: "/home/kostya05983/Projects/Blog/build/distributions",
    filename: "Blog-unspecified.js"
};

// source maps
config.module.rules.push({
        test: /\.js$/,
        use: ["source-map-loader"],
        enforce: "pre"
});
config.devtool = 'eval-source-map';

// source maps runtime
if (!config.entry) config.entry = [];
config.entry.push('source-map-support/browser-source-map-support.js');

// save evaluated config file
var util = require('util');
var fs = require("fs");
var evaluatedConfig = util.inspect(config, {showHidden: false, depth: null, compact: false});
fs.writeFile("/home/kostya05983/Projects/Blog/build/reports/webpack/Blog/webpack.config.evaluated.js", evaluatedConfig, function (err) {});

// Report progress to console
(function(config) {
    const webpack = require('webpack');
    const handler = (percentage, message, ...args) => {
        const p = percentage*100;
        let msg = Math.trunc(p/100) + Math.trunc(p%100) + '% ' + message + ' ' + args.join(' ');
        msg = msg.replace(new RegExp("/home/kostya05983/Projects/Blog/build/js", 'g'), '');
        console.log(msg);
    };

    config.plugins.push(new webpack.ProgressPlugin(handler))
})(config);
module.exports = config
