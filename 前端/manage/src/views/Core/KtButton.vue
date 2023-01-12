<template>
  <el-button :size="size" :type="type" :icon="icon"
    :loading="loading" @click="handleClick">
    {{label}}
  </el-button>
</template>

<script>
// import { hasPermission } from '@/permission/index.js'
export default {
  name: 'KtButton',
  props: {
    label: {  // 按钮显示文本
      type: String,
      default: 'Button'
    },
    icon: {  // 按钮显示图标
      type: String,
      default: ''
    },
    size: {  // 按钮尺寸
      type: String,
      default: 'mini'
    },
    type: {  // 按钮类型
      type: String,
      default: null
    },
    loading: {  // 按钮加载标识
      type: Boolean,
      default: false
    },
    disabled: {  // 按钮是否禁用
      type: Boolean,
      default: false
    }
  },
  data() {
    return {
    }
  },
  methods: {
    handleClick: function () {
      // 按钮操作处理函数
      this.$emit('click', {})
    }
  },
  mounted() {
  }
}
</script>

<style scoped>

</style>