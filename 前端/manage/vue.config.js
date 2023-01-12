module.exports = {
  runtimeCompiler: true,
  devServer: {
	  port:8081,
    proxy: {
      '/api': {
        target: 'http://10.120.0.14:8080',
        changeOrigin: true,
        pathRewrite: {
          '^/api': ''
        }
      }
    }
  }
}
