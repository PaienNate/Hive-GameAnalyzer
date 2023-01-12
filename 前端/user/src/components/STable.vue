<template>
    <div class="row container container-products">
        <div class="span6">
            <table class="table-products table-hover">
                <colgroup>
                    <col style="width:119px">
                    <col>
                    <col style="width:120px">
                </colgroup>
                <thead>
                    <tr>
                        <th v-for="item in head" class="table-title" :colspan=item.span>
                            {{item.label}}
                        </th>
                    </tr>
                </thead>
                <tbody>
                    <tr class="app" v-for="(row,i) in model">
                        <td class="applogo">
                            <a :href="'#/pages/analyse/'+row.appid" tabindex="-1" aria-hidden="true">
                                <img :src="'https://cdn.cloudflare.steamstatic.com/steam/apps/' + row.appid +'/capsule_sm_120.jpg'"
                                    alt="">
                            </a>
                        </td>
                        <td>
                            <a :href="'#/pages/devtips/'+row.appid" class="css-truncate">{{ row.appname }}</a>
                        </td>
                        <td class="text-center green">
                            {{ row.value }}
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>

</template>

<script>
export default {
    name: 'STable',
  data() {
    return {
    };
  },
  props:{
    head:
        {
            type: Array,
            default: function () {
		  	return [
                {
                    label:"aaa",
                    span:2
                },
                {
                    label:"bbb",
                    span:1
                }
            ]
		  }
        },
    model:{
        type:Array,
        default:function()
        {
            return [
                {
                    appid: 246620,
                    appname:"Plague Inc:Evolved",
                    value:"123456"
                },
                {
                    appid: 105600,
                    appname:"Terraria",
                    value:"123456"
                },
                {
                    appid: 730,
                    appname:"CSGO",
                    value:"123456"
                }
            ]
        }
    }
    

  },
  methods: {

  },
  mounted() {

  }
};






</script>

<style scoped>
font-face {
    font-family: Inter;
    font-style: normal;
    font-weight: 400;
    font-display: swap;
    src: url(/fonts/Inter-Regular.woff2) format("woff2")
}

@font-face {
    font-family: Inter;
    font-style: italic;
    font-weight: 400;
    font-display: swap;
    src: url(/fonts/Inter-Italic.woff2) format("woff2")
}

@font-face {
    font-family: Inter;
    font-style: normal;
    font-weight: 700;
    font-display: swap;
    src: url(/fonts/Inter-Bold.woff2) format("woff2")
}
:root {
    -moz-tab-size: 4;
    tab-size: 4;
    --navbar-height: 48px;
    --body-bg-color: #161920;
    --body-color: #ddd;
    --contrast-color: #fff;
    --muted-bg-color: #213145;
    --muted-color: #999;
    --border-color: hsl(216deg 25% 30%);
    --border-color-2: hsl(216deg 25% 16%);
    --link-color: #00aff4;
    --link-color-hover: #0095ff;
    --bg-green: #030;
    --bg-blue: #00174d;
    --state-text-color: #111;
    --state-owned: 89 185 70;
    --state-wished: 102 148 255;
    --state-watched: 87 132 168;
    --state-followed: 211 222 234;
    --state-cart: 247 203 8;
    --state-ignored: 191 191 191;
    --tooltip-bg: rgb(255 255 255 / 80%);
    --tooltip-green: #577c27;
    color-scheme: dark;
    scrollbar-color: var(--border-color) var(--body-bg-color)
}
thead {
    display: table-header-group;
    vertical-align: middle;
    border-color: inherit;
}
.table-products .applogo img {
    width: 107px;
    height: 40px;
}
img{
    display: block;
}
.table-products {
    width: 100%;
    margin-bottom: 20px;
    border-collapse: collapse;
    table-layout: fixed;
    word-break: break-word;
    color:#fff;
}
table {
    max-width: 100%;
    border-collapse: separate;
    border-spacing: 0;
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: left;
    overflow:hidden;
}
.container-products {
    --muted-bg-color: #1f232e;
    --border-color-2: #292e3d;
    width: 100%;
    max-width: 1440px;
}
td,th {
    padding: 0
}
.table-products {
    width: 100%;
    margin-bottom: 20px;
    /* border-collapse: collapse; */
    /* table-layout: fixed; */
    /* word-break: break-word; */
}

.container-products .table-title {
    text-align: left;
    font-size: 20px;
    font-weight: 400;
    line-height: 50px;
}

.table-products tr {
    border-bottom: 1px solid var(--border-color-2);
}

.container-products .span6 {
    background-color: var(--muted-bg-color);
    margin-top: 20px;
    padding: 0 15px 15px;
    border-radius: 6px;
    /*width: calc(50% - 10px);*/
}
.container-products .table-products th,.container-products .table-products,.container-products .table-products a {
    color: #fff
}
*,*:before,*:after {
    box-sizing: inherit;
}
a{
    text-decoration:none;
    font: 14px/20px "Microsoft YaHei",Inter,微软雅黑,"Microsoft JhengHei",-apple-system,Segoe UI,Roboto,Helvetica Neue,Arial,sans-serif,"Apple Color Emoji","Segoe UI Emoji",Segoe UI Symbol;
}
.green {
    color: #a3cf06;
}

tbody>tr:hover{
  /* filter: brightness(1.5); */
  background-color: hsl(216deg 25% 30%);
}
</style>
