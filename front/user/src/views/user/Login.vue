<template>
  <div class="container-wrapper">
    <div class="halo-logo animated fadeInUp" style="text-align: center">
      <span style="font-family: 'Arial';font-size: 32px;color: #1890ff">
        计算机科普网
      </span>
    </div>

    <a-form-model ref="loginForm" :model="from.info" :rules="from.rules" layout="vertical" @keyup.enter.native="handleLogin()">
      <a-form-model-item class="animated fadeInUp">
      <a-input placeholder="用户名/邮箱" v-model="from.info.username" :style="{ 'animation-delay': '0.1s' }">
        <a-icon slot="prefix" type="user" style="color: rgba(0,0,0,.25)" />
      </a-input>
      </a-form-model-item>

      <a-form-model-item>
        <a-input v-model="from.info.password" type="password" placeholder="密码">
          <a-icon slot="prefix" type="lock" style="color: rgba(0,0,0,.25)" />
        </a-input>
      </a-form-model-item>
      <a-form-model-item>

        <a-form-model-item class="animated fadeInUp" :style="{ 'animation-delay': '0.3s' }">
          <a-button
              type="primary"
              :block="true"
              @click="handleLogin()">登 录</a-button>
        </a-form-model-item>
      </a-form-model-item>
    </a-form-model>
  </div>
</template>
<script>
export default {
  name:'Login',
  methods: {
    handleLogin () {
      this.$refs.loginForm.validate(valid => {
        if (valid) {
          // 验证成功
          this.$axios.get("http://localhost:9090/hello").then(res => {
            console.log(res.data)
          })
          // 发送登录请求
          console.log(this.from.info)
        }
      })
    }
  },
  data () {
    return {
      from: {
        info: {
          username: null,
          password: null
        },
        rules: {
          username: [{ required: true, message: '* 用户名/邮箱不能为空', trigger: ['change'] }],
          password: [{ required: true, message: '* 密码不能为空', trigger: ['change'] }],
        }
      }
    }
  }
}
</script>