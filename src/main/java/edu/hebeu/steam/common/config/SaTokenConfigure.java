package edu.hebeu.steam.common.config;

import cn.dev33.satoken.strategy.SaStrategy;
import edu.hebeu.steam.pojo.Login.LoginBean;
import edu.hebeu.steam.util.baseutil.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SaTokenConfigure {
    /**
     * 重写 Sa-Token 框架内部算法策略
     */
    @Autowired
    public void rewriteSaStrategy() {
        // 重写 Token 生成策略
        SaStrategy.me.createToken = (loginId, loginType) -> {
            LoginBean loginBean = (LoginBean)loginId;
            return TokenUtil.sign(loginBean.getName(),loginBean.getPassword());    // 随机60位长度字符串
        };
    }
}
