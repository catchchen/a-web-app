import axios from 'axios'
import Vue from 'vue'

// 响应拦截 获取 响应中的数据
// axios.interceptors.response.use(res => {
//   return res.data
// })
// 下挂在Vue原型上
Vue.prototype.$axios = axios

// base_url = api

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

// users
/**
 * put
 * 修改user info
 */

// /user{userId}/articles/{id}/status
/**
 * user change article status
 *
 */


// /user/login
/**
 * user login
 * 用户登录
 * 返回 auth token
 */

// Article Status

    /**
     * 已发布
     */
    // PUBLISHED(1),

    /**
     * editing 需要继续编写的
     */
    // EDITING(2),
    /**
     * 回收站
     */
    // RECYCLE(3),
    //
    // DELETE(4);

