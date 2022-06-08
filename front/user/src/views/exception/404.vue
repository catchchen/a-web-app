<template>
  <div>
    <h1>404</h1>
    <a-result status="404" title="404" sub-title="Sorry, the page you visited does not exist.">
      <template #extra>
        <a-button type="primary" @click="handleToHome">返回首页</a-button>
      </template>
    </a-result>

  </div>
</template>

<script>
export default {
  name: '400',
  methods: {
    handleToHome () {
      this.$router.push("/main")
    }
  }
}
</script>

<style lang="less" scoped>
.page-container {
}
</style>
