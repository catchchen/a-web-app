module.exports = {
  devServer: {
    // 服务的端口号
    port: 8081,
    // 启动时 自动打开网页
    open: false,
    // 代理规则
    proxy: {
      // 以api开头的请求 代理到服务器地址,这个路径是代理到服务器,
      "api/": {
        target: 'http://localhost:9090/api/',
        secure: false,
        // 开启跨域请求
        changeOrigin: true,
        // 重写路径运行后就代理到对应的地址
        // pathRewrite: { '^/api': '' }
      }
    }
  },
  // 关闭 eslint 检查
  lintOnSave: false,
  css: {
    loaderOptions: {
      less: {
        javascriptEnabled: true
      }
    }
  }
}