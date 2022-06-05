<template>
  <div class="exception">
    <a-result :status="type" :title="type" :subTitle="config[type].desc">
      <template v-slot:extra>
        <a-button type="primary" @click="handleToHome">返回仪表盘</a-button>
      </template>
    </a-result>
  </div>
</template>

<script>
export default {
  name: "ErrorPage"
}
</script>

<style scoped>

</style>