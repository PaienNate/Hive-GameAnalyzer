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
         <zui-button @click="onButtonClick('link')">联系我们</zui-button>
         <zui-button @click="onButtonClick('case')">典型案例</zui-button>
         <zui-button @click="onButtonClick('plan')">解决方案</zui-button>
         <zui-button @click="onButtonClick('service')">产品服务</zui-button>
         <zui-button @click="onButtonClick('home')">首页</zui-button>
    </zui-header>
    <div class="banner vivify fadeIn">
      <h1 class="vivify popIn">
        <span class="br">智慧社区，</span>三网融合、物联网、云计算、传感网
      </h1>
      <h3 class="vivify popIn">文化为引领，物业为基础，服务为核心</h3>
    </div>
    <div class="nav clear">
      <a class="zhichou vivify popIn">
        <div class="watermark blue">平台</div>
        <logo type="zhongtai"></logo>
        <logo class="mobile" type="mzhichou"></logo>
        <h3>解决企业技术难题</h3>
        <h4>不用自建研发队伍>></h4>
      </a>
      <a class="hr vivify popIn delay-200">
        <div class="watermark green">节约</div>
        <logo type="hr"></logo>
        <logo class="mobile" type="mhr"></logo>
        <h3>节约控制开发成本</h3>
        <h4>灵活·专业·快速·低价>></h4>
      </a>
      <a class="plus vivify popIn delay-400">
        <div class="watermark blue">保障</div>
        <logo type="plus"></logo>
        <logo class="mobile" type="mplus"></logo>
        <h3>保障平台无间断运营</h3>
        <h4>后顾无忧·迅速迭代版本更新>></h4>
      </a>
    </div>
   <!-- <a class="join-zhichou" href="http://wx.zhichou.com/#/me/resume">
      我是牛人，入驻智筹 >>
    </a> -->
    <div class="service">
      <h1>
        专业互联网研发集成平台<br/>
        承担你的研发任务
      </h1>
      <h3>
        自带技术平台，马上开工，迅速上线！
      </h3>
      <h4>
        APP开发(android、ios) | 微信开发 | 网站开发 | H5开发<br/>
        我们就是你的开发团队
      </h4>
    </div>
   
     <div class="apply-hr">
       <h2>
         选择智慧互联，选择优质服务
       </h2>
       <h4>
         行业解决方案咨询和实施，提供多业务领域的信息化平台咨询、建设及运营托管服务
       </h4>
     </div>
    <zui-footer/>
  </page>
</template>
<script>
  import './sass/home-page.scss'
  import Logo from '../../components/HomePage/Logo'
  import Page from '../../components/HomePage/Page'
  import ZuiHeader from '../../components/HomePage/Header'
  import ZuiFooter from '../../components/HomePage/Footer'
  import ZuiButton from '../../components/HomePage/Button'
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
            this.$router.push({path:'/service'})
        }else if(e=="plan"){
            this.$router.push({path:'/plan'})
        }else if(e=="case"){
            this.$router.push({path:'/case'})
        }else if(e=="link"){
            this.$router.push({path:'/link'})
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
       this.$router.push({path:'/service'})
      },
      goplan: function () {
       this.$router.push({path:'/plan'})
      },
      gocase: function () {
       this.$router.push({path:'/case'})
      },
      golink: function () {
       this.$router.push({path:'/link'})
      },
    }

  }
</script>
