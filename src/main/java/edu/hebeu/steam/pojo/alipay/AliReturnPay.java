package edu.hebeu.steam.pojo.alipay;

import com.baomidou.mybatisplus.annotation.TableField;
import edu.hebeu.steam.pojo.Base.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AliReturnPay extends BaseModel implements Serializable {
    private static final long serialVersionUID = 8683949075381016639L;
    // 开发者的app_id
    private String app_id;
    // 商户订单号
    private String out_trade_no;
    // 签名
    private String sign;
    // 交易状态
    private String trade_status;
    // 支付宝交易号
    private String trade_no;
    // 交易的金额
    private String total_amount;
}
