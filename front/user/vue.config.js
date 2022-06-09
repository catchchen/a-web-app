module.exports = {
  devServer: {
    // 代理规则
    proxy: {
      "/v1": {
        // 以v1开头的请求 代理到服务器地址,这个路径是代理到服务器,
        target: 'http://localhost:9090/api',
        // https 是否启用
        secure: false,
        // 开启跨域请求
        changeOrigin: true,
        // 重写路径运行后就代理到对应的地址
        pathRewrite: { '^/v1': ''}
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