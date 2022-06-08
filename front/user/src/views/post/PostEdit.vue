<template>
<div>
  <div class="mb-4">
  <a-input v-model="postToStage.title" placeholder="请输入文章标题" size="large" />
  </div>
  <markdown-editor
  :originalContent="postToStage.originalContent"
  @onSaveDraft="handleSave(true)"
  @onContentChange="onContentChange"
  />
  <Button @click="handlePostArticle" text="发布"></Button>
</div>
</template>

<script>
import  Button from '@/components/Reactive'
import MarkdownEditor from '@/components/Editor/MarkdownEditor'
export default {
  name: 'PostEditor',
  components: {
    MarkdownEditor,
    Button
  },
  data () {
    return {
      title: '',
      postToStage: {
        title: '',
        originalContent: ''
      },
    }
  },
  beforeRouteEnter(to, from, next) {
    // 编辑情况 router中传入 query 文章id 获取文章内容
    const postId = to.query.postId
    next(async vm => {
      if (postId) {
        const { data } = this.$axios.get(Number(postId))
            //await apiClient.post.get(Number(postId))
        vm.postToStage = data
      }
    })
  },
  methods: {
    handlePostArticle () {

    },
    onContentChange(val) {
      this.postToStage.originalContent = val
      console.log(val)
    },
  }

}
</script>

<style lang="less">
@import url('../../style/global.less');
.h-full{
    height: 100vh;
    overflow: auto;
}

</style>