import {createRouter, createWebHashHistory, onBeforeRouteUpdate} from 'vue-router'

const Login = import('../views/Login.vue')

const constantRoutes = [{
    path: '/login',
    component: Login,
    hidden: true
  },{
    path: '/403',
    component: () => import('../views/error/403.vue'),
    hidden: true
},{
    path: '/404',
    component: () => import('../views/error/404.vue'),
    hidden: true
  },{
    path: '/500',
    component: () => import('../views/error/500.vue'),
    hidden: true
  }
]
const Layout = import('../layout/Layout.vue')
const PostList = import('../views/PostList')
const UserList = import('../views/Home')
// 需要守卫的路由
const asyncRoutes = [
  {
    path: '/',
    component: Layout,
    redirect: '/post',
    children: [
        {
            path: '/post',
            component: PostList
        },{
          path:  '/user',
          component: UserList
        }
    ]
  }
]

export default createRouter({
  // history vue-router 4 hash 模式
  history: createWebHashHistory(),
  // router
  routes: constantRoutes.concat(asyncRoutes)
})
