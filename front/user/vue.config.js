module.exports = {
  devServer: {
    // 服务的端口号
    port: 8080,
    // 启动时 自动打开网页
    open: true,
    // 代理规则
    proxy: {
      // 代理的目标服务器地址,这个路径是我代理到服务器,
      "api/": {
        target: 'http://localhost:9090',
        secure: false,
        changeOrigin: true,
        // 重写路径运行后就代理到对应的地址
        pathRewrite: { '^/api': '' }
      }
    }
  },
  lintOnSave: false,
  css: {
    loaderOptions: {
      less: {
        javascriptEnabled: true
      }
    }
  }
}