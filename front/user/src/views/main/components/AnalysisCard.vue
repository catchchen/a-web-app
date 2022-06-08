<template>
<div>
  <a-card>
    <h2>{{title}}</h2>
    card {{startNumber}}
  </a-card>
</div>
</template>

<script>
import countTo from 'vue-count-to'
export default {
  name: 'AnalysisCard',
  components: {
    countTo
  },
  props: {
    title: {
      type: String,
      required: false,
      default: ''
    },
    number: {
      type: Number,
      required: false,
      default: 0
    }
  },
  data() {
    return {
      startNumber: 0
    }
  },
  watch: {
    number: function(newValue, oldValue) {
      this.startNumber = oldValue
    }
  }
}
</script>
