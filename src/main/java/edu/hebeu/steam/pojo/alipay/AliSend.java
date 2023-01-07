package edu.hebeu.steam.pojo.alipay;


import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class AliSend {

    /**
     * outTradeNo
     */
    @JSONField(name = "out_trade_no")
    private String outTradeNo;
    /**
     * totalAmount
     */
    @JSONField(name = "total_amount")
    private String totalAmount;
    /**
     * subject
     */
    @JSONField(name = "subject")
    private String subject;
    /**
     * storeId
     */
    @JSONField(name = "store_id")
    private String storeId;
    /**
     * timeoutExpress
     */
    @JSONField(name = "timeout_express")
    private String timeoutExpress;
}
