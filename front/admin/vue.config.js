module.exports = {
    devServer: {
        port: 8888,
        open: false,
        proxy: {
            '/api/admin': {
                target: 'http://localhost:9090/',
                secure: false,
                changeOrigin: true,
            }
        }
    },
    css: {
        loaderOptions: {
            less: {
                javascriptEnabled: true
            }
        }
    }
}
