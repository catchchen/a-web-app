<template>
  <a-layout class="app-wapper">
  <!--  左 side-->
    <a-layout-sider class="app-sider" :trigger="null" v-model:collapsed="collapsed" collapsible>
      <a-menu theme="dark" mode="inline" v-model:selectedKeys="selectedKeys" :style="{ height: '100%', borderRight: 0 }">
        <a-sub-menu key="sub1">
          <template #title>
            <user-outlined />
            <span>
              用户管理
            </span>
          </template>
          <a-menu-item key="1">用户列表</a-menu-item>
          <a-menu-item key="2">用户信息</a-menu-item>
        </a-sub-menu>
        <a-sub-menu key="sub2">
          <template #title>
            <upload-outlined />
            <span>
              文章管理
            </span>
          </template>
          <a-menu-item key="5">文章列表</a-menu-item>
          <a-menu-item key="6">发布文章</a-menu-item>
        </a-sub-menu>
        <a-sub-menu key="sub3">
          <template #title>
            <video-camera-outlined />
            <span>
              video
            </span>
          </template>
          <a-menu-item key="7">vi列表</a-menu-item>
          <a-menu-item key="8">vi文章</a-menu-item>
        </a-sub-menu>
      </a-menu>
    </a-layout-sider>
  <!--  右main-->
    <a-layout>
      <!-- header -->
      <a-layout-header class="app-header">
        <menu-unfold-outlined v-if="collapsed" class="trigger" @click="() => (collapsed = !collapsed)"/>

        <menu-fold-outlined v-else class="trigger" @click="() => (collapsed = !collapsed)" />
      </a-layout-header>
        <!-- 面包屑 -->
        <a-layout style="padding: 0 24px 24px">
          <a-breadcrumb style="margin: 16px 0">
            <a-breadcrumb-item>Home</a-breadcrumb-item>
            <a-breadcrumb-item>List</a-breadcrumb-item>
            <a-breadcrumb-item>App</a-breadcrumb-item>
          </a-breadcrumb>
          <!-- Content -->
          <a-layout-content :style="{ background: '#fff', padding: '24px', margin: 0, minHeight: '280px' }">

            <router-view></router-view>

          </a-layout-content>
        </a-layout>
    </a-layout>
  </a-layout>
</template>
<script>
import {
  UserOutlined,
  VideoCameraOutlined,
  UploadOutlined,
  MenuUnfoldOutlined,
  MenuFoldOutlined,
} from '@ant-design/icons-vue'
import {reactive, toRefs} from 'vue'
export default {
  setup() {
    const state = reactive({
      collapsed: false,
      selectedKeys: ['1']
    })
    return {
      ...toRefs(state)
    }
  },
  components:{
  UserOutlined,
  VideoCameraOutlined,
  UploadOutlined,
  MenuUnfoldOutlined,
  MenuFoldOutlined,
  }
}
</script>

<style lang="less">
.app-wapper {
  .app-sider {
    left: 0;
    height: 100vh;
    overflow: auto;
  }
  .app-header{
    padding: 0;
    background: #fff;
    .trigger {
      font-size: 18px;
      line-height: 64px;
      padding:0 24px;
      cursor: pointer;
      transition: color 0.3s;
    }
  }
}
</style>