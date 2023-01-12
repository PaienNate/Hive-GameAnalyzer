package edu.hebeu.steam.pojo.alipay;

import edu.hebeu.steam.pojo.Base.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class AliSQLPay extends BaseModel {
    private String appId;
    // 商户订单号
    private String outTradeNo;
    // 签名
    private String sign;
    // 交易状态
    private String tradeStatus;
    // 支付宝交易号
    private String tradeNo;
    // 交易的金额
    private String totalAmount;
}
