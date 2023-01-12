<template>
  <page class="home-page">
    <zui-header>
      <logo type="xiaoyanyun" href="/"></logo>
        <h4 class="zui-logo-text"> 
         |&nbsp;&nbsp;BlackCat游戏数据分析平台
         <br/>|&nbsp;&nbsp;供游戏开发者
        </h4>
         <div class="zui-rightcol" @click="openMenu" style="color: #0b8ba5;">◄目录►</div>
         <drop-list :config="configData" ref="droplist"></drop-list>
         <!-- <zui-button @click="onButtonClick('link')">联系我们</zui-button> -->
         <zui-button @click="onButtonClick('case')">多方面分析</zui-button>
         <zui-button @click="onButtonClick('plan')">受欢迎游戏</zui-button>
         <zui-button @click="onButtonClick('service')">词云</zui-button>
         <zui-button @click="onButtonClick('home')">首页</zui-button>
    </zui-header>
    <RouterView />
  </page>
</template>

<script>
  import './sass/home-page.scss'
  import Logo from '../../components/HomePage/Logo.vue'
  import Page from '../../components/HomePage/Page.vue'
  import ZuiHeader from '../../components/HomePage/Header.vue'
  import ZuiFooter from '../../components/HomePage/Footer.vue'
  import ZuiButton from '../../components/HomePage/Button.vue'
  import DropList from 'vue-droplist'
  export default{
    components: {Page, Logo, ZuiHeader, ZuiFooter,ZuiButton,DropList},
    data () {
      return {
        feature1: "feature1",
        feature2: "feature2",
        feature3: "feature3",
        feature4: "feature4",
        carouselPerPage: 1,
        configData : {
            position: {  // 设置显示位置，position
              top: '60px',
              right: '15px',
              bottom: '',
              left: ''
            },
            width: '40%', // 设置宽度
            list: [ // 设置下拉列表数据和对应的点击事件
              {text: '首页', action: this.gohome},
              {text: '产品服务', action: this.goservice},
              {text: '解决方案', action: this.goplan},
              {text: '典型案例', action: this.gocase},
              {text: '联系我们', action: this.golink}
            ]
        }
      }
    },
   methods: {
    onButtonClick: function (e) {
        if(e=="home"){
            this.$router.push({path:'/'})
        }else if(e=="service"){
            this.$router.push({path:'/pages/wordcloud'})
        }else if(e=="plan"){
            this.$router.push({path:'/pages/likedgames'})
        }else if(e=="case"){
            this.$router.push({path:'/pages/charts'})
        }else if(e=="link"){
            this.$router.push({path:'/pages/'})
        }else{
            this.$router.push({path:'/'})
        }
      },
      openMenu: function () {
       this.$refs.droplist.show()
      },
      gohome: function () {
       this.$router.push({path:'/'})
      },
      goservice: function () {
       this.$router.push({path:'/pages/wordcloud'})
      },
      goplan: function () {
       this.$router.push({path:'/pages/likedgames'})
      },
      gocase: function () {
       this.$router.push({path:'/pages/charts'})
      },
      golink: function () {
       this.$router.push({path:'/pages/'})
      },
    }

  }
</script>
