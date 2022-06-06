import axios from 'axios'
import Vue from 'vue'

// 响应拦截
axios.interceptors.response.use(res => {
  return res.data
})

Vue.prototype.$axios = axios

// userApi.postArticle = () => {
//   return a({
//     url: `${baseUrl}/article`,
//     method: 'get'
//   })
// }

// userApi.updateProfile = profile => {
//   return service({
//     url: `${baseUrl}/profiles`,
//     method: 'put',
//     data: profile
//   })
// }
//
// userApi.updatePassword = (oldPassword, newPassword) => {
//   return service({
//     url: `${baseUrl}/profiles/password`,
//     method: 'put',
//     data: {
//       oldPassword: oldPassword,
//       newPassword: newPassword
//     }
//   })
// }