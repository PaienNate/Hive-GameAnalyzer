<template>
  <div :class="cls">
    <slot></slot>
    <zui-loading v-if="loadingVisible"/>
  </div>
</template>
<script>
  import './sass/page.scss'
  import './sass/vivify.min.css'
  import ZuiToast from './Toast'
  import ZuiLoading from './Loading'
  import Util from './Util'

  export default {
    props: {
      title: '智筹'
    },
    components: {
      ZuiToast,
      ZuiLoading
    },
    computed: {
      cls () {
        const cls = (Util.os.android || Util.os.iPhone) ? '' : 'min-1200'
        return 'zui-page ' + cls
      },
      toastText () {
        return this.$store.state.toastText
      },
      loadingVisible () {
        return this.$store.state.loadingVisible
      }
    }
  }
</script>
