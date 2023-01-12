package edu.hebeu.steam.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import edu.hebeu.steam.annotation.Log;
import edu.hebeu.steam.annotation.LogAli;
import edu.hebeu.steam.common.page.PageRequest;
import edu.hebeu.steam.common.result.CommonResult;
import edu.hebeu.steam.pojo.Login.LoginBean;
import edu.hebeu.steam.pojo.Sys.SysUser;
import edu.hebeu.steam.pojo.alipay.AliReturnPay;
import edu.hebeu.steam.pojo.alipay.SysPay;
import edu.hebeu.steam.service.AliService;
import edu.hebeu.steam.controller.websocket.WebSocket;
import edu.hebeu.steam.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@RestController
@Slf4j
@RequestMapping("ali")
public class AliPayController {
    @Autowired
    private WebSocket webSocket;	// 导入刚刚写好的 WebSocket 工具类
    @Autowired
    private AliService aliService;
    @Autowired
    private UserService userService;


    @ApiOperation(value = "支付宝支付 沙箱环境")
    @PostMapping("/sandboxPay")
    @ResponseBody
    @LogAli("支付宝支付")
    public CommonResult sandboxPay() throws AlipayApiException {
        LoginBean loginBean = new LoginBean();
        String loginjson = (String) StpUtil.getLoginIdDefaultNull();
        if(loginjson!=null)
        {
            loginBean = JSON.parseObject(loginjson,LoginBean.class);
        }
        return CommonResult.success("获取成功",aliService.CreateAliPayTask(loginBean));
    }
    @ApiOperation(value = "支付宝支付 异步通知")
    @PostMapping("/call")
    @LogAli("支付宝回调")
    public void call(AliReturnPay aliReturnPay, HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 通知返回的数据会封装到 AliReturnPay 类中
        response.setContentType("type=text/html;charset=UTF-8");
        String orderNo = aliReturnPay.getOut_trade_no(); // 获得订单号，对数据进行修改
        // 支付成功的返回码
        if (("TRADE_SUCCESS").equals(aliReturnPay.getTrade_status())){
            // 向前端发送一条支付成功的通知
            String userid = orderNo.split("%")[0];
            SysUser user = userService.findById(Long.parseLong(userid));
            user.setStatus((byte)1);
            if(userService.save(user))
            {
                webSocket.sendMessage("true");
            }
            webSocket.sendMessage("error");
        }
        else
        {
            webSocket.sendMessage("false");
        }
    }
    @ApiOperation(value = "支付宝 日志查询")
    @PostMapping(value="/findPage")
    public CommonResult findPage(@RequestBody PageRequest pageRequest) {
        return CommonResult.success(aliService.findPage(pageRequest));
    }
}
