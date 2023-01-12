package edu.hebeu.steam.pojo.Login;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginBean {
    /** 用户名 */
    private String name;
    /** 密码 */
    private String password;
    /** 验证码 */
    private String captcha;

    @Override
    public String toString()
    {
        //返回JSON的属性
        return JSON.toJSONString(this);
    }

}
