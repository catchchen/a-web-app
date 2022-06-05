import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import {setupAntd} from './ant-design-vue'
// import Antd from 'ant-design-vue'
const app = createApp(App)
setupAntd(app)
app.use(router)
app.mount('#app')
