import {createRouter, createWebHashHistory} from 'vue-router'

const constantRoutes = [{
    path: '/login',
    component: () => import('../views/Login.vue'),
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

const asyncRoutes = [
  {
    path: '/',
    component: () => import('../layout/Layout.vue')
  }
]

export default createRouter({
  // history vue-router4 hash 模式
  history: createWebHashHistory(),
  // router
  routes: constantRoutes.concat(asyncRoutes)
})

