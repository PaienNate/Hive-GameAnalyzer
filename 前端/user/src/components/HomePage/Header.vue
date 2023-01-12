<template>
  <header class="zui-header">
    <slot></slot>
  </header>
</template>
<script>
  import './sass/header.scss'
  import Logo from './Logo.vue'
  export default {
    props: {
      logoType: {
        default: 'zhichou'
      }
    },
    components: {Logo}
  }
</script>
