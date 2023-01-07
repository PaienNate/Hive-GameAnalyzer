package edu.hebeu.steam.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import edu.hebeu.steam.alipay.AliReturnPay;
import edu.hebeu.steam.config.AliConfig;
import edu.hebeu.steam.pojo.alipay.AliSend;
import edu.hebeu.steam.service.AliService;
import edu.hebeu.steam.websocket.WebSocket;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static edu.hebeu.steam.config.AliConfig.*;

@Controller
@Slf4j
public class AliPayController {
    @Autowired
    private WebSocket webSocket;	// 导入刚刚写好的 WebSocket 工具类
    @Autowired
    private AliService aliService;


    @ApiOperation(value = "支付宝支付 沙箱环境")
    @PostMapping("/sandboxPay")
    @ResponseBody
    public String sandboxPay() throws AlipayApiException {
        return aliService.CreateAliPayTask();

    }
    @ApiOperation(value = "支付宝支付 异步通知")
    @PostMapping("/call")
    public void call(HttpServletRequest request, HttpServletResponse response, AliReturnPay aliReturnPay) throws IOException {
        // 通知返回的数据会封装到 AliReturnPay 类中
        response.setContentType("type=text/html;charset=UTF-8");
        String orderNo = aliReturnPay.getOut_trade_no(); // 获得订单号，对数据进行修改
        // 支付成功的返回码
        if (("TRADE_SUCCESS").equals(aliReturnPay.getTrade_status())){
            // 向前端发送一条支付成功的通知
            webSocket.sendMessage("true");
        }
    }


}
