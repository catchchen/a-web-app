<template>
  <a-layout class="app-wapper">
<!--    left side bar-->
    <a-layout-sider class="app-sider" :trigger="null" v-model:collapsed="collapsed" collapsible>
      <a-menu theme="dark" mode="inline" :style="{ height: '100%', borderRight: 0 }">
        <a-menu-item key="1">
          <a-icon type="user" />
          <span>我的信息</span>
        </a-menu-item>
        <a-menu-item key="2">
          <a-icon type="video-camera" />
          <span>编辑文章</span>
        </a-menu-item>
        <a-menu-item key="3">
          <a-icon type="upload" />
          <span><router-link to="/list">文章管理</router-link></span>
        </a-menu-item>
      </a-menu>
    </a-layout-sider>
    <a-layout>
      <a-layout-header style="background: #fff; padding: 0">
        <a-icon
            class="trigger"
            :type="collapsed ? 'menu-unfold' : 'menu-fold'"
            @click="() => (collapsed = !collapsed)"
        />
      </a-layout-header>
      <a-layout-content
          :style="{ margin: '24px 16px', padding: '24px', background: '#fff', minHeight: '280px' }"
      >
        <router-view />
      </a-layout-content>
      <Footer />
    </a-layout>
  </a-layout>
</template>

<script>
import Footer from '@/components/Footer/Footer'
export default {
  name: 'BasicLayout',
  data () {
    return {
      collapsed: false,
    }
  },
  components: {
    // Header,
    Footer,
    // SideMenu,
    // RouteView
  },
}
</script>

<style lang="less">
@import url('../style/global.less');
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
