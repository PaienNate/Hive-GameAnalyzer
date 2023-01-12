<template>
  <div class="header-wrapper">
    <div class="container">
      <div class="pagehead">
        <div class="d-flex flex-grow">
          <img class="app-icon avatar"
            src="https://cdn.cloudflare.steamstatic.com/steamcommunity/public/images/apps/467090/fdb42cf15bab497d1f0b5af2fb12f577d991c68c.jpg"
            alt="" width="32" height="32" />
          <h1 itemprop="name">A Game of Changes</h1>
        </div>
        <div class="pagehead-actions app-links">
          <a href="/extension/" id="js-extension-wishlist" class="tooltipped tooltipped-n disabled" aria-label="Install our browser extension to be able
to wishlist on Steam store directly">Wishlist</a>
          <a href="/extension/" id="js-extension-follow" class="tooltipped tooltipped-n disabled" aria-label="Install our browser extension to be able
to follow on Steam store directly">Follow</a>
          <a href="/extension/" id="js-extension-ignore" class="tooltipped tooltipped-n disabled" aria-label="Install our browser extension to be able
to ignore on Steam store directly">Ignore</a>
          <a href="steam://install/467090" class="tooltipped tooltipped-n" id="js-app-install" aria-label="Launch Steam and try installing this game
steam://install/467090">
            <svg version="1.1" width="16" height="16" viewBox="0 0 16 16" class="octicon octicon-steam"
              aria-hidden="true">
              <path
                d="M8 0a8 8 0 00-8 7.47c.07.1.13.21.18.32l4.15 1.67a2.2 2.2 0 011.31-.36l1.97-2.8v-.04c0-1.65 1.37-3 3.05-3a3.03 3.03 0 013.05 3 3.03 3.03 0 01-3.12 3l-2.81 1.97c0 .3-.05.6-.17.9a2.25 2.25 0 01-4.23-.37L.4 10.56A8.01 8.01 0 108 0zm2.66 4.27c-1.12 0-2.03.9-2.03 2s.91 1.99 2.03 1.99c1.12 0 2.03-.9 2.03-2s-.9-2-2.03-2zm0 .5c.85 0 1.53.66 1.53 1.49s-.68 1.5-1.53 1.5c-.84 0-1.52-.67-1.52-1.5s.68-1.5 1.52-1.5zM5.57 9.6c-.22 0-.43.04-.62.11l1.02.42c.65.26.95.99.68 1.62-.27.63-1 .93-1.65.67l-1-.4a1.73 1.73 0 003.13-.08c.18-.42.18-.88.01-1.3A1.69 1.69 0 005.57 9.6z">
              </path>
            </svg>
            <span>Install</span>
          </a>
          <a href="/login/?page=app%2F467090%2Fgraphs" rel="nofollow" role="button" class="tooltipped tooltipped-n"
            aria-label="You must be signed in to watch an app"><svg version="1.1" width="16" height="16"
              viewBox="0 0 16 16" class="octicon octicon-eye" aria-hidden="true">
              <path fill-rule="evenodd"
                d="M1.679 7.932c.412-.621 1.242-1.75 2.366-2.717C5.175 4.242 6.527 3.5 8 3.5c1.473 0 2.824.742 3.955 1.715 1.124.967 1.954 2.096 2.366 2.717a.119.119 0 010 .136c-.412.621-1.242 1.75-2.366 2.717C10.825 11.758 9.473 12.5 8 12.5c-1.473 0-2.824-.742-3.955-1.715C2.92 9.818 2.09 8.69 1.679 8.068a.119.119 0 010-.136zM8 2c-1.981 0-3.67.992-4.933 2.078C1.797 5.169.88 6.423.43 7.1a1.619 1.619 0 000 1.798c.45.678 1.367 1.932 2.637 3.024C4.329 13.008 6.019 14 8 14c1.981 0 3.67-.992 4.933-2.078 1.27-1.091 2.187-2.345 2.637-3.023a1.619 1.619 0 000-1.798c-.45-.678-1.367-1.932-2.637-3.023C11.671 2.992 9.981 2 8 2zm0 8a2 2 0 100-4 2 2 0 000 4z">
              </path>
            </svg>
            <span id="js-watch-text">Watch</span></a>
        </div>
      </div>
      <div class="row app-row">
        <el-container>
          <el-aside width="620px" style="overflow: visible;">
            <div class="span8">
              <el-table :data="tableData"  style="width: 100%" border class="table table-bordered table-hover table-responsive-flex">
                <el-table-column prop="date" label="日期">
                </el-table-column>
                <el-table-column prop="name" label="姓名">
                </el-table-column>
              </el-table>
            </div>
          </el-aside>
          <el-main style="overflow: visible;">
            <div class="span4">
              <div class="js-open-screenshot-viewer">
                <img src="https://cdn.cloudflare.steamstatic.com/steam/apps/730/header.jpg?t=1672884572"
                  class="app-logo" itemprop="image" alt="" width="324" height="151" />
              </div>
              <div class="header-two-things">
                <a href="/blog/steamdb-rating/" class="header-thing tooltipped tooltipped-n" aria-label="58.33% of the 84 user reviews are positive.

SteamDB Rating">
                  <div class="header-thing-number header-thing-white">
                    ❓ 56.15%
                  </div>
                  <span class="header-thing-good">↑49</span>
                  <span class="header-thing-poor">↓35</span>
                </a>
                <a href="/app/467090/graphs/" class="header-thing header-thing-poor" id="js-graphs-button">
                  <div class="header-thing-number">363</div>
                  In-Game
                </a>
              </div>
              <p class="header-description" itemprop="description">
                A 3d puzzle platformer that takes you along a journey of wisdom,
                through the 64 unique worlds that draw inspiration and teachings
                from the I Ching [Book of Changes], one of the oldest oracles in
                human history.
              </p>
            </div>
          </el-main>
        </el-container>
      </div>
    </div>
  </div>
</template>
<script>
 export default {
      data() {
        return {
          tableData: [{
            date: '2016-05-02',
            name: '王小虎',
            address: '上海市普陀区金沙江路 1518 弄'
          }, {
            date: '2016-05-04',
            name: '王小虎',
            address: '上海市普陀区金沙江路 1517 弄'
          }, {
            date: '2016-05-01',
            name: '王小虎',
            address: '上海市普陀区金沙江路 1519 弄'
          }, {
            date: '2016-05-03',
            name: '王小虎',
            address: '上海市普陀区金沙江路 1516 弄'
          }]
        }
      }
    }
</script>

<style scoped lang="scss">


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





/* 表格内背景颜色 */
::v-deep .el-table th,
::v-deep .el-table tr,
::v-deep .el-table td {
 background-color: transparent !important;
 border: 0; //去除表格
}


::v-deep .el-table th.is-leaf{
  border: 1px solid rgb(57,73,96);
}
::v-deep .el-table td.is-leaf{
  border: 1px solid rgb(57,73,96);
}

::v-deep .el-table--border
{
  border: 1px solid rgb(57,73,96);
}
::v-deep .el-table::before {
  height: 0px;
}
::v-deep .el-table::after {
  height: 0px;
}

.el-table--border th.el-table__cell.gutter:last-of-type {
    border-bottom: 1px solid #000;
    border-bottom-width: 1px;
}


::v-deep .el-table {
  background-color: rgb(22,25,32);
  font: 14px/20px Inter,"微软雅黑",PingFangSC-Medium,-apple-system,Segoe UI,Roboto,Helvetica Neue,Arial,sans-serif,"Apple Color Emoji","Segoe UI Emoji",Segoe UI Symbol;


}

.el-aside {
  height: 100vh;
}

.container {
  width: 960px;
  padding-left: 10px;
  padding-right: 10px;
  margin-right: auto;
  margin-left: auto;
}

.el-main {
  padding: 0px;
}

.pagehead h1 {
  margin-top: 0;
  margin-bottom: 0;
  font-size: 20px;
  font-weight: 400;
  line-height: 28px;
  color: var(--contrast-color);
  flex-grow: 1;
}

h1,
h2,
h3,
h4,
h5,
h6 {
  margin: 10px 0;
}

h1 {
  display: block;

  margin-block-start: 0.67em;
  margin-block-end: 0.67em;
  margin-inline-start: 0px;
  margin-inline-end: 0px;
}

.pagehead .app-links {
  margin-left: 10px;
  flex-shrink: 0;
}

.app-links {
  font-size: 0;
}

.row {
  display: flex;
  flex: 0 1 auto;
  flex-flow: row wrap;
  column-gap: 20px;
}

.flex-grow {
  flex-grow: 1;
}

.d-flex {
  display: flex;
}

.pagehead .app-icon {
  flex-shrink: 0;
  margin-bottom: -4px;
  margin-right: 10px;
}

.avatar {
  display: inline-block;
  overflow: hidden;
  line-height: 1;
  vertical-align: middle;
  border-radius: 6px;
  background: #121212 url(/static/img/appicon.svg);
}

.app-links a.disabled {
  background: rgb(103 193 245 / 10%);
  color: #66c1f566;
}

.app-links>a {
  margin-right: 5px;
  display: inline-block;
  cursor: pointer;
  color: #67c1f5;
  background: #273b4b;
  padding: 0 10px;
  font-size: 15px;
  line-height: 30px;
  border-radius: 6px;
}

.pagehead {
  display: flex;
  padding-top: 20px;
  padding-bottom: 20px;
  word-break: break-all;
}

div {
  display: block;
}

.table-bordered thead:first-child tr:first-child th,
.table-bordered tbody:first-child tr:first-child th,
.table-bordered tbody:first-child tr:first-child td {
  border-top: 0;
}

.table-bordered th:first-of-type,
.table-bordered td:first-of-type {
  border-left: 0;
}

.table-bordered th,
.table-bordered td {
  border-left: 1px solid hsl(216deg 25% 30%);
}

.span3 {
  width: 220px;
}

td {
  display: table-cell;
}

.table th,
.table td {
  padding: 8px;
  line-height: 20px;
  text-align: left;
  vertical-align: top;
  border-top: 1px solid #394960;
}

.table {
  width: 100%;
  margin-bottom: 20px;
  word-break: break-word;
}

.table {
  max-width: 100%;
  border-collapse: separate;
  border-spacing: 0;
}

.table {
  text-indent: initial;
}

.header-two-things {
  display: flex;
  gap: 10px;
}

.header-thing-white {
  color: #aaa;
}

.header-thing-poor {
  color: #ff683b;
}

.header-thing-number {
  font-size: 22px;
  /* color: #ff683b; */
  line-height: 1.2;
}

.header-thing-good {
  color: #6c3;
}

.header-thing {
  margin-top: 10px;
  text-align: center;
  padding: 8px;
  display: inline-block;
  background-color: #213145;
  color: #999;
  font-size: 12px;
  border-radius: 6px;
  flex-basis: 0;
  flex-grow: 1;
  width: 100%;
}

.tooltipped {
  position: relative;
}

a {
  color: #00aff4;
  text-decoration: none;
}

*,
*:before,
*:after {
  box-sizing: inherit;
}

a:-webkit-any-link {
  cursor: pointer;
}

.header-description {
  word-wrap: break-word;
  margin: 10px 0 0;
}

p {
  margin: 0 0 10px;
}

*,
*:before,
*:after {
  box-sizing: inherit;
}

.header-wrapper {
  color: #ddd;
  background-color: #161920;
  margin: 0;
}

.common-table-container .el-table__expanded-cell {
  background-color: #313856;
  color: #fff;
}
p {
  display: block;
  margin-block-start: 1em;
  margin-block-end: 1em;
  margin-inline-start: 0px;
  margin-inline-end: 0px;
}

:root {
  --charts-players: #c8ff00;
  --charts-twitch: #0277bd;
}

:root {
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
}

*,
*:before,
*:after {
  box-sizing: inherit;
}

*,
*:before,
*:after {
  box-sizing: inherit;
}
</style>
