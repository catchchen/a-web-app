import Vue from 'vue'

import FilePondUpload from './FilePondUpload'
// import AttachmentSelectDrawer from './Attachment/AttachmentSelectDrawer'
import ReactiveButton from './ReactiveButton'

const _components = {
  // 文件上传 主键
  FilePondUpload,
  ReactiveButton
}

const components = {}

Object.keys(_components).forEach(key => {
  // 注册组件
  components[key] = Vue.component(key, _components[key])
})

export default components

/**
 * 已发布
 */
// PUBLISHED(1),

/**
 * editing 需要继续编写的
 */
// EDITING(2),
/**
 * 回收站
 */
// RECYCLE(3),


// DELETE(4);
