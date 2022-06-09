import Vue from 'vue'
import App from './App.vue'
import router from './router'
// import store from './store/'
// 引入axios发送 http网络请求
import '@/api/user'
// 按需引入 ant-design-vue组件
import './ant-design-vue'
// ant-design-vue 样式
import 'ant-design-vue/dist/antd.less'
import '@/style/tailwind.css'

Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
