// axios.js
import axios from 'axios'

axios.interceptors.response.use(res => {
    return res.data
})


axios.interceptors.response.use(res => {
    return res.data
})

const AdminApi = axios.create({
    baseURL:process.env.BASE_API,
    // headers: {'Content-Type': 'application/json'},
    timeout: 1000,
})

export default AdminApi;



// index.js

import AdminApi from './axios'

const api = {}

api.login = (loginForm) => {
    return AdminApi.post('/login', loginForm)
}

export default api;

// BASE_API=/api/admin

// GET /api/admin/users

/**
 * get all users
 */

// GET /api/admin/users/{userId}
/**
 * get user info by userId
 */

// DELETE /api/admin/users/{userId}

/**
 * delete user by userId
 */

// put /api/admin/users/{userId}/status

// put /api/admin/posts/public
/**
 * change user status
 *
 * change post status
 */

// DELETE /api/admin/posts/{articleId}
/**
 * delete user post article by articleId
 */
