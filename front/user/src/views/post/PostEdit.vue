<template>
<div>
  <div class="mb-4">
  <a-input v-model="postToStage.title" placeholder="请输入文章标题" size="large" />
  </div>
  <markdown-editor
  :originalContent="postToStage.originalContent"
  @onSaveDraft="handleSave()"
  @onContentChange="onContentChange"
  />
  <a-space>
    <Button @click="handlePostArticle" text="发布"></Button>
    <Button type="" @click="handlePostArticle" text="保存草稿"></Button>
    <a-button type="dashed" @click="handleSave">清空</a-button>
    <a-button type="" @click="handleTest">Test</a-button>
  </a-space>
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
      // title: '',
      postToStage: {
        title: '',
        originalContent: ''
      },
    }
  },
  beforeRouteEnter(to, from, next) {
    next()
    // 编辑情况 router中传入 query 文章id 获取文章内容
    // const postId = to.query.postId
    // next(async vm => {
    //   if (postId) {
    //     const { data } = this.$axios.get(Number(postId))
    //         //await apiClient.post.get(Number(postId))
    //     vm.postToStage = data
    //   }
    // })
  },
  methods: {
    handleTest () {
    },
    handleSave(){
      this.$axios.get(`/v1/hello`).then( res => {
        console.log(res)
      })
    },
    handlePostArticle () {
      //  前端check userId 和 title不为空
      let userId = Number.parseInt(localStorage.getItem("userId"));
      if(isNaN(userId)) {
        userId = 100000 ;
      }
      // 发布文章 调用
      this.$axios.post(`/v1/user/${userId}/articles`, {
          title: this.postToStage.title,
          originContent: this.postToStage.originalContent,
          status: 1
      }).then(res => {
        console.log(res.data)
        if(res.data.code == 200)
        this.$message.info(res.data.message)
        else this.$message.warn(res.data.message)

      })
    },
    onContentChange(val) {
      this.postToStage.originalContent = val
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