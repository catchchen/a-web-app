// eslint-disable-next-line
// import { BasicLayout, BlankLayout, PageView } from '@/layouts'

export const RouterMap = [
  {
    path: '/',
    name: 'index',
    // component: BasicLayout,
    meta: { title: '首页' },
    redirect: '/home',
    children: [
      // dashboard
      {
        path: '/home',
        name: 'Home',
        component: () => import('@/views/Home'),
        meta: { title: '首页', icon: 'home', hiddenHeaderContent: false, keepAlive: false }
      },

      // posts
      {
        path: '/posts',
        name: 'Posts',
        // component: BlankLayout,
        redirect: '/posts/list',
        meta: { title: '文章', icon: 'form' },
        children: [
          {
            path: '/posts/list',
            name: 'PostList',
            component: () => import('@/views/post/PostList'),
            meta: { title: '所有文章', hiddenHeaderContent: false }
          },
          {
            path: '/posts/write',
            name: 'PostWrite',
            component: () => import('@/views/post/PostEdit'),
            meta: { title: '写文章', hiddenHeaderContent: false, keepAlive: false }
          },
          {
            path: '/posts/edit',
            name: 'PostEdit',
            hidden: true,
            component: () => import('@/views/post/PostEdit'),
            meta: { title: '编辑文章', hiddenHeaderContent: false, keepAlive: false }
          },
          {
            path: '/categories',
            name: 'CategoryList',
            component: () => import('@/views/post/CategoryList'),
            meta: { title: '分类目录', hiddenHeaderContent: false }
          },
          {
            path: '/tags',
            name: 'TagList',
            component: () => import('@/views/post/TagList'),
            meta: { title: '标签', hiddenHeaderContent: false }
          }
        ]
      },

      // attachments
      {
        path: '/attachments',
        name: 'Attachments',
        component: () => import('@/views/attachment/AttachmentList'),
        meta: { title: '附件', icon: 'picture', hiddenHeaderContent: false }
      },

      // comments
      {
        path: '/comments',
        name: 'Comments',
        component: () => import('@/views/comment/CommentList'),
        meta: { title: '评论', icon: 'message', hiddenHeaderContent: false }
      },

      // interface
      {
        path: '/interface',
        name: 'Interface',
        // component: BlankLayout,
        redirect: '/interface/themes',
        meta: { title: '外观', icon: 'skin' },
        children: [
          {
            path: '/interface/themes',
            name: 'ThemeList',
            component: () => import('@/views/interface/ThemeList'),
            meta: { title: '主题', hiddenHeaderContent: false }
          },
          {
            path: '/interface/themes/setting',
            name: 'ThemeSetting',
            component: () => import('@/views/interface/ThemeSetting'),
            meta: { title: '主题设置', hiddenHeaderContent: false }
          },
          {
            path: '/interface/themes/edit',
            name: 'ThemeEdit',
            component: () => import('@/views/interface/ThemeEdit'),
            meta: { title: '主题编辑', hiddenHeaderContent: false }
          },
          {
            path: '/interface/menus',
            name: 'MenuList',
            component: () => import('@/views/interface/MenuList'),
            meta: { title: '菜单设置', hiddenHeaderContent: false }
          }
        ]
      },

      // user
      {
        path: '/user',
        name: 'User',
        // component: PageView,
        redirect: '/user/profile',
        meta: { title: '用户', icon: 'user' },
        children: [
          {
            path: '/user/profile',
            name: 'Profile',
            component: () => import('@/views/user/Profile'),
            meta: { title: '个人资料', hiddenHeaderContent: false }
          }
        ]
      }
    ]
  },
  {
    path: '/interface/themes/setting/visual',
    name: 'ThemeVisualSetting',
    hidden: true,
    component: () => import('@/views/interface/ThemeVisualSetting'),
    meta: { title: '主题设置', hiddenHeaderContent: false }
  },
  {
    path: '*',
    redirect: '/404',
    hidden: true
  }
]

export const constantRouterMap = [
  {
    path: '/login',
    name: 'Login',
    meta: { title: '登录' },
    component: () => import('@/views/user/Login')
  },
  {
    path: '/install',
    name: 'Install',
    meta: { title: '安装向导' },
    component: () => import('@/views/system/Installation')
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
