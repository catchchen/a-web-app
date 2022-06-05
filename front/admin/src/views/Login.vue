<template>
  <div class="login-container">
    <a-row>
      <a-col :xs="0" :md="0" :sm="12" :lg="12" :xl="10"></a-col>
      <a-col :xs="24" :sm="24" :md="12" :lg="6" :xl="6">
        <div class="login-container-form">
          <header>
            <img src="@/assets/logo.png" alt="">
            <h1>管理员后台</h1>
          </header>
          <a-form :model="form" @submit="handleSubmit" @submit.prevent>
            <a-form-item>
              <a-input v-model:value="form.username" size="large" placeholder="Username">
                <template v-slot:prefix><user-outlined type="user"/></template>
              </a-input>
            </a-form-item>

            <a-form-item>
              <a-input v-model:value="form.password" type="password" size="large" placeholder="Password">
                <template v-slot:prefix><lock-outlined type="user" /></template>
              </a-input>
            </a-form-item>
            <a-form-item>
              <a-input type="submit" style="background-color: lightskyblue">
              <a-button type="primary" size="large" block>
                  登录
              </a-button>
              </a-input>
            </a-form-item>
          </a-form>
        </div>
      </a-col>
    </a-row>
  </div>
</template>

<script>
import { UserOutlined, LockOutlined } from '@ant-design/icons-vue'
import { defineComponent,reactive, toRefs } from 'vue'
import {message} from 'ant-design-vue'
import {  useRouter } from 'vue-router'
import api from '../api/index'
export default defineComponent({
  name: "Login",
  components: {
    UserOutlined, LockOutlined
  },
  setup() {
    const router = useRouter();
    const to = () => router.push({ path: '/' })
    const state = reactive({
      form: {
        username: '',
        password: ''
      }
    })
    const handleSubmit = () => {
      const { username, password } = state.form
      if( username.trim() == '' || password.trim() == ''){
        return message.warning('用户名密码不能为空')
      }
      api.login(state.form).then(res => {
        if(res.data.code == 200) {
          localStorage.setItem('admin', JSON.stringify(res.data))
          to()
          // 跳转路由
          message.info('登陆成功');
        } else {
          message.warn('用户名或密码错误')
        }
      })
    }

    return {
      to,
      ...toRefs(state),
    handleSubmit
    }
  }

});
</script>

<style lang="less" scoped>
.login-container {
  text-align: center;
  height: 100vh;
}
</style>