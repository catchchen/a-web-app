<template>
  <div class="login-container">
    <a-row>
      <a-col :xs="0" :md="0" :sm="12" :lg="12" :xl="16"></a-col>
      <a-col :xs="24" :sm="24" :md="12" :lg="10" :xl="6">
        <div class="login-container-form">
          <header>
            <img src="@/assets/logo.png" alt="">
            <h1>admin-back font</h1>
          </header>

          <a-form :model="form" @submit="handleSubmit" @submit.prevent>
            <a-form-item>
              <a-input v-model:value="form.username" size="large" placeholder="Username">
                <template v-slot:prefix><user-outlined type="user"/></template>
              </a-input>
            </a-form-item>

            <a-form-item>
              <a-input v-model:value="form.password" size="large" placeholder="Password">
                <template v-slot:prefix><lock-outlined type="user" /></template>
              </a-input>
            </a-form-item>
            <a-form-item>
              <a-button type="primary" size="large" @click="handleSubmit" block>
                Login in
              </a-button>
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
import {login} from '../api'
export default defineComponent({
  name: "Login",
  components: {
    UserOutlined, LockOutlined
  },
  setup() {
    const state = reactive({
      form: {
        username: '',
        password: ''
      }
    })

    const handleSubmit = async () => {
      const {username, password} = state.form
      if(username.trim() == '' || password.trim() == ''){
        return message.warning('用户名密码不能为空')
      }
      const res = await login(state.form)
      console.log(res)
    }

    return {
      ...toRefs(state),
    handleSubmit
    }
  }
});
</script>

<style lang="less" scoped>
.login-container {
  height: 100vh;
}
</style>