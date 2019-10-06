{
  mode: 'development',
  resolve: {
    modules: [
      'node_modules'
    ]
  },
  plugins: [],
  module: {
    rules: [
      {
        test: /\.js$/,
        use: [
          'source-map-loader'
        ],
        enforce: 'pre'
      }
    ]
  },
  entry: [
    '/home/kostya05983/Projects/Blog/build/js/packages/Blog/kotlin/Blog.js',
    'source-map-support/browser-source-map-support.js'
  ],
  output: {
    path: '/home/kostya05983/Projects/Blog/build/distributions',
    filename: 'Blog-unspecified.js'
  },
  devtool: 'eval-source-map'
}