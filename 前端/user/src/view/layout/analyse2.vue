<template>
  <div class="container container-table">
    <div class="header-wrapper d-flex">
      <h1 class="header-title flex-grow">
        <span class="muted"><a href="/developers/">Developers</a> »</span> Nuno
        Donato
      </h1>
    </div>
    <div class="table-responsive">
      <div id="table-apps_wrapper" class="dataTables_wrapper">
        <div class="dataTable_display">
          <div class="dataTables_length" id="table-apps_length">
            <label
              >Show
              <select
                name="table-apps_length"
                aria-controls="table-apps"
                class=""
              >
                <option value="25">25</option>
                <option value="50">50</option>
                <option value="100">100</option>
                <option value="250">250</option>
                <option value="1000">1K</option>
                <option value="5000">5K</option>
                <option value="-1">All (slow)</option>
              </select>
              entries</label
            >
            <label>
              | Search:
              <input
                type="search"
                class=""
                placeholder=""
                aria-controls="table-apps"
            /></label>
          </div>
          <div id="table-apps_filter" class="dataTables_filter">
            <div class="header-filter-buttons">
              <Alipay class="btn btn-info">CLICK ON</Alipay>
            </div>
          </div>
        </div>
        <div class="dataTable_table_wrap">
          <el-container>
            <el-main width="100%">
              <div class="span8">
                <el-table
                  :data="tableData"
                  style="width: 100%"
                  border
                  class="table table-bordered table-hover table-responsive-flex"
                  align="center"
                >
                  <el-table-column prop="id" label="AppID" width="103">
                  </el-table-column>
                  <el-table-column prop="photo" label="Pic" width="130">
                    <template slot-scope="scope">
                      <img
                        style="width: 110px; height: 40px"
                        :src="scope.row.photo"
                      />
                    </template>
                  </el-table-column>
                  <el-table-column prop="name" label="Name" width="290">
                  </el-table-column>
                  <el-table-column label="Link" min-width="200">
                    <template slot-scope="scope">
                      <a
                        :href="'http://' + scope.row.Address"
                        target="_blank"
                        class="buttonText"
                        >{{ scope.row.Address }}</a
                      >
                    </template>
                  </el-table-column>

                  <el-table-column
                    prop="rate"
                    label="Rating"
                    width="100"
                  ></el-table-column>
                  <el-table-column
                    prop="foll"
                    label="Followers"
                    width="100"
                  ></el-table-column>
                  <el-table-column
                    prop="on"
                    label="Online"
                    width="100"
                  ></el-table-column>
                  <el-table-column
                    prop="peak"
                    label="Peak"
                    width="100"
                  ></el-table-column>
                  <el-table-column
                    prop="year"
                    label="Year"
                    width="60"
                  ></el-table-column>
                </el-table>
              </div>
            </el-main>
          </el-container>
        </div>
      </div>
    </div>
  </div>
</template>
<script setup>
import { reactive } from "vue";
import { useRoute } from "vue-router";
import Alipay from "@/components/Alipay.vue";
const route = useRoute()
console.log(route.params["gameId"]) //这是参数
const tableData = reactive([
  {
    date: "2016-05-02",
    name: "王小虎",
    address: "上海市普陀区金沙江路 1518 弄",
  },
  {
    date: "2016-05-04",
    name: "王小虎",
    address: "上海市普陀区金沙江路 1517 弄",
  },
  {
    date: "2016-05-01",
    name: "王小虎",
    address: "上海市普陀区金沙江路 1519 弄",
  },
  {
    date: "2016-05-03",
    name: "王小虎",
    address: "上海市普陀区金沙江路 1516 弄",
  },
]);
</script>
<style scoped>
font-face {
  font-family: Inter;
  font-style: normal;
  font-weight: 400;
  font-display: swap;
  src: url(/fonts/Inter-Regular.woff2) format("woff2");
}

@font-face {
  font-family: Inter;
  font-style: italic;
  font-weight: 400;
  font-display: swap;
  src: url(/fonts/Inter-Italic.woff2) format("woff2");
}

@font-face {
  font-family: Inter;
  font-style: normal;
  font-weight: 700;
  font-display: swap;
  src: url(/fonts/Inter-Bold.woff2) format("woff2");
}

/* 表格内背景颜色 */
::v-deep .el-table th,
::v-deep .el-table tr,
::v-deep .el-table td {
  background-color: transparent !important;
  border: 0;
}

::v-deep .el-table th.is-leaf {
  border: 1px solid rgb(57, 73, 96);
}
::v-deep .el-table td.is-leaf {
  border: 1px solid rgb(57, 73, 96);
}

::v-deep .el-table--border {
  border: 1px solid rgb(57, 73, 96);
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
  background-color: rgb(22, 25, 32);
  font: 14px/20px Inter, "微软雅黑", PingFangSC-Medium, -apple-system, Segoe UI,
    Roboto, Helvetica Neue, Arial, sans-serif, "Apple Color Emoji",
    "Segoe UI Emoji", Segoe UI Symbol;
}
.container {
  background: rgb(22, 25, 32);
}
.container-table {
  max-width: 1240px;
}
.container {
  padding-left: 20px;
  padding-right: 20px;
  /* margin-right: 0; 
    margin-left: 0;  */
}
.d-flex {
  display: flex;
}
.flex-grow {
  flex-grow: 1;
}
.header-title {
  color: #fff;
  font-size: 28px;
  line-height: 1.7;
  text-align: left;
}
h1 {
  font-weight: 400;
}
h1,
h2,
h3,
h4,
h5,
h6 {
  margin: 10px 0;
}
.muted,
.muted > a {
  color: #999;
}
.header-filter-buttons {
  display: flex;
  align-self: center;
}
.btn-info {
  color: #fff;
  background-color: #643ab0;
  box-shadow: 0 1px #1b1f231a, inset 0 1px #ffffff08;
}
.btn {
  position: relative;
  display: inline-block;
  padding: 8px 12px;
  font-size: 13px;
  font-weight: 700;
  line-height: 20px;
  color: #24292e;
  white-space: nowrap;
  vertical-align: middle;
  cursor: pointer;
  margin-right: 20px;
  border: 1px solid #394960;
  border-radius: 6px;
  user-select: none;
  appearance: none;
}
a {
  text-decoration: none;
}
.dataTable_bottom,
.dataTable_display {
  margin: 5px 0;
  display: flex;
  justify-content: space-between;
}
.dataTables_length select {
  width: 75px;
  display: inline-block;
  margin: 0 5px;
}
select {
  height: 20px;
  appearance: none;
}
.input,
input[type="text"],
input[type="search"],
input[type="date"],
select,
textarea {
  min-height: 34px;
  padding: 7px 8px;

  color: #ddd;
  vertical-align: middle;
  background-color: #161920;
  background-repeat: no-repeat;
  background-position: right center;
  border: 1px solid #394960;
  border-radius: 6px;
  outline: none;
}
button,
select {
  text-transform: none;
}
button,
input,
optgroup,
select,
textarea {
  font-family: inherit;
  line-height: 1.15;
}
/* .dataTables_length label:after {
    content: ". Hold Shift to sort multiple columns.";
    color: #aaa;
} */
.dataTables_filter {
  font-size: 16px;
}
.dataTables_filter label {
  font-weight: 400;
  font-size: 16px;
  white-space: nowrap;
}
.input,
input[type="text"],
input[type="search"],
input[type="date"],
select,
textarea {
  min-height: 34px;
  padding: 7px 8px;
  font-size: 14px;
  color: #ddd;
  vertical-align: middle;
  background-color: #161920;
  background-repeat: no-repeat;
  background-position: right center;
  border: 1px solid #394960;
  border-radius: 6px;
  outline: none;
}
.dataTables_filter input {
  margin-left: 0.5em;
  display: inline-block;
  width: auto;
}
[type="search"] {
  -webkit-appearance: textfield;
  outline-offset: -2px;
}
input {
  accent-color: #00aff4;
}
button,
input,
optgroup,
select,
textarea {
  font-family: inherit;
  line-height: 1.15;
  margin: 0;
}
.text-center,
td.text-center {
  text-align: center;
}
.table-products {
  width: 100%;
  margin-bottom: 20px;
  border-collapse: collapse;
  table-layout: fixed;
  word-break: break-word;
}
table {
  max-width: 100%;

  border-spacing: 0;
}
.dataTable_bottom,
.dataTable_display {
  margin: 15px 0;
  display: flex;
  justify-content: space-between;
}
.dataTables_info {
  font-size: 16px;
}
.dataTable_bottom .pagination {
  margin: 0;
  text-align: unset;
}
.pagination {
  margin: 20px 0;
  text-align: center;
  font-size: 16px;
}
.pagination .active,
.pagination .active:hover,
.pagination .active:focus {
  color: #fff;
  background-color: #0366d6;
  border-color: transparent;
}
.pagination a,
.pagination span {
  display: inline-block;
  margin: 0 3px;
  min-width: 32px;
  padding: 5px 10px;
  font-style: normal;
  line-height: 20px;
  text-align: center;
  white-space: nowrap;
  vertical-align: middle;
  user-select: none;
  border: 1px solid transparent;
  border-radius: 6px;
}
*,
*:before,
*:after {
  box-sizing: inherit;
}
nav {
  display: block;
}
.pagination .disabled,
.pagination .disabled:hover,
.pagination .disabled:focus {
  color: #999;
  cursor: default;
  border-color: transparent;
}
.pagination a,
.pagination span {
  display: inline-block;
  margin: 0 3px;
  min-width: 32px;
  padding: 5px 10px;
  font-style: normal;
  line-height: 20px;
  text-align: center;
  white-space: nowrap;
  vertical-align: middle;
  user-select: none;
  border: 1px solid transparent;
  border-radius: 6px;
}
a {
  color: var(--link-color);
  text-decoration: none;
}
select:not(:-internal-list-box) {
  overflow: visible !important;
}

select {
  writing-mode: horizontal-tb !important;
  /* font-style: ;
  font-variant-ligatures: ;
  font-variant-caps: ;
  font-variant-numeric: ;
  font-variant-east-asian: ;
  font-weight: ;
  font-stretch: ;
  font-size: ;
  font-family: ; */
  text-rendering: auto;
  color: fieldtext;
  letter-spacing: normal;
  word-spacing: normal;
  line-height: normal;
  text-transform: none;
  text-indent: 0px;
  text-shadow: none;
  display: inline-block;
  text-align: start;
  appearance: auto;
  box-sizing: border-box;
  align-items: center;
  white-space: pre;
  -webkit-rtl-ordering: logical;
  background-color: field;
  cursor: default;
}
input {
  writing-mode: horizontal-tb !important;

  text-rendering: auto;

  letter-spacing: normal;
  word-spacing: normal;

  text-transform: none;
  text-indent: 0px;
  text-shadow: none;

  text-align: start;

  -webkit-rtl-ordering: logical;
  cursor: text;
}
table {
  display: table;

  text-indent: initial;

  border-color: grey;
}
h1 {
  display: block;

  margin-block-start: 0.67em;
  margin-block-end: 0.67em;
  margin-inline-start: 0px;
  margin-inline-end: 0px;
}
div {
  display: block;
}
.dataTable_bottom .pagination {
  margin: 0;
  text-align: unset;
}
.pagination {
  margin: 20px 0;
  text-align: center;
  font-size: 16px;
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