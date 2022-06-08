<template>
    <a-result status="500" title="500" sub-title="Sorry, the server is wrong.">
      <template #extra>
        <a-button type="primary" @click="handleToHome">
          Back Home
        </a-button>
      </template>
    </a-result>
</template>

<script>

export default {
    name: '500',
  methods: {
    handleToHome () {}

  }
}
</script>
