<template>
  <div>
    <h2>文章列表</h2>
    <div style="margin-bottom: 16px">
<!-- 使用 expire 控制 用户写文章的状态-->
      <a-button type="primary" :disabled="!true" :loading="loading" @click="editorArticle">
        <router-link to="/write">
          写文章
        </router-link>
      </a-button>
      <span style="margin-left: 8px">
        <template v-if="hasSelected">
          {{ `Selected ${selectedRowKeys.length} items` }}
        </template>
      </span>
    </div>

    <a-table
        :row-selection="{ selectedRowKeys: selectedRowKeys }"
        :columns="columns"
        :data-source="data"
    />
  </div>
</template>

<script>

const columns = [
  {
    title: '文章标题',
    dataIndex: 'name',
  },
  {
    title: '状态',
    dataIndex: 'status',
  },
  {
    title: '操作',
    dataIndex: 'address',
  },
];

const data = [];
// 假数据
for (let i = 0; i < 46; i++) {
  data.push({
    key: i,
    name: `Edward King ${i}`,
    status: 32,
    address: `London, Park Lane no. ${i}`,
  });
}

export default {
  name: 'PostList',
  data () {
    return {
      data,
      columns,
      selectedRowKeys:[],
      loading: false
    }
  },
  // beforeMounted(){
  //
  // },
  methods: {
    getPostList () {
      // this.$axios.get()
    },
    editorArticle () {
      console.log("11")
    }
  }
}
</script>