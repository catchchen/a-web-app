import axios from 'axios'
import Vue from 'vue'

// 响应拦截 获取 响应中的数据
axios.interceptors.response.use(res => {
  return res.data
})
// 下挂在Vue原型上
Vue.prototype.$axios = axios

// /user/{userId}/articles
/**
 * post
 * user post article
 */
// /user/{userId}/article/{id}
/**
 * get
 * user get article
 */

// /user{userId}/articles/{id}/status
/**
 * user change article status
 */
// /user/login
/**
 * user login
 */

