<template>
  <a-layout class="app-wapper">
<!--    left side bar-->
<!--    <a-layout-sider class="app-sider" :trigger="null" v-model:collapsed="collapsed" collapsible>-->
      <a-layout-header :style="{ position: 'fixed', zIndex: 10000, width: '100%' }">
      <a-menu theme="dark"
              mode="horizontal"
              :default-selected-keys="['3']"
              :style="{ lineHeight: '64px' }">
        <a-menu-item key="1">
          <a-icon type="user" />
          <span>我的信息</span>
        </a-menu-item>
        <a-menu-item key="2">
          <a-icon type="video-camera" />
          <span><router-link to="/write">编辑文章</router-link></span>
        </a-menu-item>
        <a-menu-item key="3">
          <a-icon type="upload" />
          <span><router-link to="/list">文章管理</router-link></span>
        </a-menu-item>
        <a-menu-item key="4">
          <span><a href="http://localhost:9090/">主页</a></span>
        </a-menu-item>
        <a-menu-item key="5" class="app-sider">
          <!--          user.avatar ||-->
          <a-avatar style="text-align: right" class="avatar" size="small" :src="'//cn.gravatar.com/avatar/?s=256&d=mm'" />
        </a-menu-item>
      </a-menu>

      </a-layout-header>
    <a-layout>
      <a-layout-content
          :style="{ margin: '46px 16px', padding: '24px', background: '#fff', minHeight: '280px' }">
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
    Footer,
  },
}
</script>

<style lang="less">
@import url('../style/global.less');

#components-layout-demo-fixed {
  width: 120px;
  height: 31px;
  background: rgba(255, 255, 255, 0.2);
  margin: 16px 24px 16px 0;
  float: left;
}

.app-wapper {
  .app-sider {
    right: 0;
  }
  //.app-header{
  //  padding: 0;
  //  background: #fff;
  //  .trigger {
  //    font-size: 18px;
  //    line-height: 64px;
  //    padding:0 24px;
  //    cursor: pointer;
  //    transition: color 0.3s;
  //  }
  //}
}

</style>
