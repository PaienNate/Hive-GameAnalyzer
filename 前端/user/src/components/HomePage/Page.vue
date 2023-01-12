<template>
  <div :class="cls">
    <slot></slot>
    <zui-loading v-if="loadingVisible"/>
  </div>
</template>
<script setup>
  import './sass/page.scss'
  import './sass/vivify.min.css'
  import ZuiToast from './Toast.vue'
  import ZuiLoading from './Loading.vue'
  import Util from './Util'
  import home from '../../store/home'
import { computed, toRefs } from 'vue'
  const store = home()
  defineProps({
    title: {
      type: String,
      default:()=>{
        return "智筹"
      }
    }
  })
  const {toastText,loadingVisible} = toRefs(store)
  const cls = computed(() =>{
        const cls = (Util.os.android || Util.os.iPhone) ? '' : 'min-1200'
        return 'zui-page ' + cls
  })
  // export default {
  //   // data() {
  //   //   return {
  //   //     Store: home()
  //   //   }
  //   // },
  //   props: {
  //     title: '智筹'
  //   },
  //   components: {
  //     ZuiToast,
  //     ZuiLoading
  //   },
  //   computed: {
  //     cls () {
  //       const cls = (Util.os.android || Util.os.iPhone) ? '' : 'min-1200'
  //       return 'zui-page ' + cls
  //     },
  //     toastText () {
  //       return home().toastText
  //     },
  //     loadingVisible () {
  //       return home().loadingVisible
  //     }
  //   }
  // }
</script>
