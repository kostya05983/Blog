'use strict';

var webpack = require('webpack');

var config = {
    "mode": "development",
    "context": "/home/kostya05983/Projects/Blog/build/js/packages/Blog/kotlin",
    "entry": {
        "Blog": "./Blog"
    },
    "output": {
        "path": "/home/kostya05983/Projects/Blog/build/bundle",
        "filename": "[name].bundle.js",
        "chunkFilename": "[id].bundle.js",
        "publicPath": "/"
    },
    "module": {
        "rules": [
            
        ]
    },
    "resolve": {
        "modules": [
            "js/packages/Blog/kotlin",
            "resources/main",
            "/home/kostya05983/Projects/Blog/build/node_modules",
            "node_modules"
        ]
    },
    "plugins": [
        
    ]
};

module.exports = config;

