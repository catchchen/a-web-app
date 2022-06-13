<template>
  <div>
    <a-card :bordered="false" :bodyStyle="{ padding: '16px' }">
      <div style="margin-bottom: 16px">
  <!-- 使用 expire 控制 用户写文章的状态 true 表示不能-->
        <a-button type="primary" :disabled="false" :loading="loading" @click="editorArticle">
          <router-link to="/write">
            写文章
          </router-link>
        </a-button>
        <span style="margin-left: 8px">
<!--          <template v-if="hasSelected">-->
<!--            {{ `Selected ${selectedRowKeys.length} items` }}-->
<!--          </template>-->
        </span>
      </div>

      <a-table
          :row-selection="{ selectedRowKeys: selectedRowKeys }"
          :columns="columns"
          :data-source="data"
      />
    </a-card>
  </div>
</template>

<script>

const columns = [
  {
    title: '文章标题',
    dataIndex: 'title',
  },
  {
    title: '状态',
    dataIndex: 'summary',
  },
 {
    title: '操作',
    dataIndex: 'address',
  },
];

// 假数据
// for (let i = 0; i < 46; i++) {
//   data.push({
//     key: i,
//     name: `Edward King ${i}`,
//     status: 32,
//     address: `London, Park Lane no. ${i}`,
//   });
// }

export default {
  name: 'PostList',
  data () {
    return {
      data: [],
      columns,
      selectedRowKeys:[],
      loading: false
    }
  },
  beforeMount(){
    console.log("00000")
    this.getPostList()
  },
  methods: {
    getPostList () {
      //  前端check userId 和 title不为空
      let userId = Number.parseInt(localStorage.getItem("userId"));
      if(isNaN(userId)) {
        userId = 100 ;
      }
      // 文章列表 调用
      this.$axios.get(`/v1/article/user/${userId}/articles`).then(res => {
        // if(res.status == 200){
          this.data = res.data
          console.log(res.data)
          this.$message.info(res.data.message);
        // } else this.$message.warn(res.data.message)
      }).then(err => {
        console.log(err)
      })


    },
    editorArticle () {
      console.log("11")
    }
  }
}
</script>