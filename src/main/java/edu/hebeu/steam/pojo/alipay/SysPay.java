package edu.hebeu.steam.pojo.alipay;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysPay extends AliSQLPay {

    private String userName;

    private String operation;

    private String method;

    private Long time;

    private String ip;

    public void TransformReturnPay(AliReturnPay returnPay)
    {
        this.setAppId(returnPay.getApp_id());
        this.setOutTradeNo(returnPay.getOut_trade_no());
        this.setSign(returnPay.getSign());
        this.setTradeNo(returnPay.getTrade_no());
        this.setTotalAmount(returnPay.getTotal_amount());
        this.setTradeStatus(returnPay.getTrade_status());
    }

}
