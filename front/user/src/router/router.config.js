import { BasicLayout, BlankLayout } from "@/layouts";
/**
 * 基础路由
 */
export const constantRouterMap = [
  {
    path: '/login',
    name: 'Login',
    meta: { title: '登录' },
    component: () => import('@/views/user/AdminLogin')
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
export const asyncRouterMap = [
  {
    path: '/',
    name: 'BasicLayout',
    component: BasicLayout,
    meta: { title: '首页' },
    redirect: '/main',
    children: [
      // main page
      {
        path: '/main',
        name: 'Dashboard',
        component: () => import('@/views/main/Dashboard'),
        meta: { title: '主页面'}
      },
      // PostList
      {
        path: '/list',
        name: 'postList',
        component: () => import('@/views/post/PostList'),
        meta: { title: 'post list'}
      },
      {
        path: '/write',
        name: 'Editor',
        component: () => import('@/views/post/PostEdit'),
        meta: {title: 'editor'}
      },
      // posts
      {
        path: '/posts',
        name: 'Posts',
        component: BlankLayout,// blank  div  router-view
        redirect: '/list',
        meta: { title: '所有发布文章' },
        children: [
          {
            path: '/posts/list',
            name: 'PostEditor',
            component: () => import('@/views/post/PostList'),
            meta: { title: '文章', icon: 'form' },
          },
          {
            path: '/posts/write',
            name: 'PostEditor',
            component: () => import('@/views/post/PostEdit'),
          },
          // {
          //   path: '/posts/edit',
          //   name: 'PostEditor',
          //   component: () => import('@/views/post/PostEdit'),
          // },
        ]
      },
      // attachments
      {
        path: '/attachments',
        name: 'Attachments',
        component: () => import('@/components/Attachment/AttachmentList'),
        meta: { title: '附件'}
      },
    ]


  }
]