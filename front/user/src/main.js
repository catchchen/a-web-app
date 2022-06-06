import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store/'
import '@/api/user'
import './ant-design-vue'
import 'ant-design-vue/dist/antd.less'
import '@/style/tailwind.css'

// import VueClipboard from 'vue-clipboard2'
// Vue.use(VueClipboard)

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App),
}).$mount('#app')
