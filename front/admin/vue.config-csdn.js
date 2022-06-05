module.exports = {
    pluginOptions: {
        proxy: {
            enabled: true,
            context: '/api',
            options: {
                target: 'http://localhost:9090',
                changeOrigin: true,
                ws: true, // websocket
                pathRewrite: {
                    '^/v1': ''
                }
            }
        }
    }
}
