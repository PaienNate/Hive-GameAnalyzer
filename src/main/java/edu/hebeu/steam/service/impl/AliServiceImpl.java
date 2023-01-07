package edu.hebeu.steam.service.impl;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import edu.hebeu.steam.pojo.alipay.AliSend;
import edu.hebeu.steam.service.AliService;
import org.springframework.stereotype.Service;

import static edu.hebeu.steam.config.AliConfig.*;
@Service
public class AliServiceImpl implements AliService {
    @Override
    public String CreateAliPayTask() throws AlipayApiException {
        AlipayClient alipayClient = new DefaultAlipayClient(URL,APP_ID,APP_PRIVATE_KEY,FORMAT,CHARSET,ALIPAY_PUBLIC_KEY,SIGN_TYPE);
        AlipayTradePrecreateRequest alipayRequest = new AlipayTradePrecreateRequest();
        // 设置支付宝异步通知回调地址
        alipayRequest.setNotifyUrl(NOTIFY_URL);
        AliSend send = new AliSend();
        //预留以后修改的接口
        send.setOutTradeNo("192030210");
        send.setSubject("sandbox应用:2088621993981307");
        send.setTimeoutExpress("90m");
        send.setTotalAmount("5");
        send.setStoreId("查看开发者大数据分析报告");
        String bizContent = JSON.toJSONString(send);
        alipayRequest.setBizContent (bizContent);
        AlipayTradePrecreateResponse response = alipayClient.execute (alipayRequest);
        // 返回支付宝支付网址，用于生成二维码
        return response.getQrCode();
    }
}
