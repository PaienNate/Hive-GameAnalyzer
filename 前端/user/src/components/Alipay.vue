<template>
  <div id="orderDiv">
    <el-button @click="toPayment" type="primary">去支付</el-button>
    <el-dialog
      title="支付宝扫码支付"
      v-model="dialogVisible"
      width="452px"
      center>
      <!--二维码生成-->
      <vueQr :text="qr" :size="400" :margin="10" :correctLevel="0" :whiteMargin="false"></vueQr>
      <span id="dialogSpan" v-show="paySucc == true"></span>
      <span id="dialogSpan2" v-show="paySucc == true">
        <i class="el-icon-success" style="background-color: #FFFFFF; color:#67C23A; font-size: 60px;border-radius: 30px;"/>
        <br/>
        支付成功
      </span>
    </el-dialog>
  </div>
</template>

<script>
  import { ElButton,ElDialog } from 'element-plus'
  import vueQr from 'vue-qr/src/packages/vue-qr.vue'
  import axios from 'axios'
  export default {
    components:{
      vueQr,ElButton,ElDialog
    },
    data(){
      return{
        dialogVisible: false,
        qr: "",
        paySucc: false
      }
    },
    methods: {
      toPayment(){
        let _this = this;
        // 这里填写后台支付的地址
        axios({
          method: 'POST',
          url: "api/ali/sandboxPay",
        }).then(res => {
          this.qr = res.data.data;
          console.log(this.qr);
          if ("WebSocket" in window) {
            // 打开一个 web socket
            // 通道地址按照项目进行配置
            var ws = new WebSocket("ws://10.120.0.14:8080/ali/bindingRecord");
            ws.onopen = function() {
              // Web Socket 已连接上，使用 send() 方法发送数据
              // ws.send("data");
              // alert("数据发送中...");
            };
            ws.onmessage = function(evt) {
              var received_msg = evt.data;
              // 接收后台推送的数据
              // alert("数据已接收..." + evt.data);
              if (Boolean(evt.data)) {
                _this.paySucc = true;
                setTimeout(() => {
                  _this.dialogVisible = false;
                }, 3 * 1000);
              }
              ws.close();
            };
            ws.onclose = function() {

            };
          } else {
            // 浏览器不支持 WebSocket
            alert("您的浏览器不支持 WebSocket!");
          }
        });
        this.dialogVisible = true;
      }
    }
  }
</script>

<style scoped>
  #dialogSpan{
    display: inline-block;
    width: 200px;
    height: 200px;
    position: absolute;
    top: 80px;
    right: 27px;
    opacity:0.9;
    background-color: #FFFFFF;
  }
  #dialogSpan2{
    display: inline-block;
    width: 100px;
    height: 100px;
    position: absolute;
    top: 124px;
    right: 80px;
    font-size: 20px;
    text-align: center;
  }
</style>

