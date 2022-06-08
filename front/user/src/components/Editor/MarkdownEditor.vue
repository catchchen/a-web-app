<template>
  <div>
    <halo-editor
      ref="md"
      v-model="originalContentData"
      :boxShadow="false"
      :toolbars="toolbars"
      :ishljs="true"
      @save="handleSave"
      autofocus
    />
  </div>
</template>
<script>
// import axios from 'axios'
import { toolbars } from '@/toolSettings/toolbars'
import { haloEditor } from 'halo-editor'
import 'halo-editor/dist/css/index.css'

export default {
  name: 'MarkdownEditor',
  components: {
    haloEditor
  },
  props: {
    originalContent: {
      type: String,
      required: false,
      default: ''
    }
  },
  data() {
    return {
      toolbars,
      originalContentData: ''
    }
  },
  watch: {
    originalContent(val) {
      this.originalContentData = val
    },
    originalContentData(val) {
      this.$emit('onContentChange', val)
    }
  },
  methods: {
    handleSave() {
      this.$emit('onSave')
    }
  }
}
</script>
