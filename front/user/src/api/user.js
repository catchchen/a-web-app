import axios from 'axios'

const baseUrl = '/api'

const userApi = {}

userApi.postArticle = () => {
  return a({
    url: `${baseUrl}/profiles`,
    method: 'get'
  })
}

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

export default userApi