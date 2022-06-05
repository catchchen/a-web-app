import { BasicLayout, BlankLayout } from "@/layouts";
/**
 * 基础路由
 */
export const constantRouter = [
  {
    path: '/login',
    name: 'Login',
    meta: { title: '登录' },
    component: () => import('@/views/user/Login')
  },
  {
    path: '/password/reset',
    name: 'ResetPassword',
    meta: { title: '重置密码' },
    component: () => import('@/views/user/ResetPassword')
  },
  {
    path: '/404',
    name: 'NotFound',
    component: () => import('@/views/exception/404')
  }
]
  /**
   * 路由
   */
export const asyncRouter = [
  {
    path: '/',
    name: 'BasicLayout',
    component: BasicLayout,
    meta: { title: '首页' },
    redirect: '/list',
    children: [
        // PostList
      {
        path: '/list',
        name: 'postList',
        component: () => import('@/views/post/PostList')
      },
      // main page
      {
        path: '/main',
        name: 'Dashboard',
        component: () => import('@/views/dashboard/Dashboard'),
        meta: { title: '主页面'}
      },
      {
        path: '/write',
        name: 'Editor',
        component: () => import('@/views/post/PostEdit'),
      },
      // posts
      {
        path: '/posts',
        name: 'Posts',
        component: BlankLayout,
        redirect: '/posts/list',
        meta: { title: '所有发布文章', icon: 'form' },
        children: [
          {
            path: '/posts/write',
            name: 'PostWrite',
            component: () => import('@/views/post/PostEdit'),
          },
          {
            path: '/posts/edit',
            name: 'PostEdit',
            component: () => import('@/views/post/PostEdit'),
          },
        ]
      },
    ]
  }
]