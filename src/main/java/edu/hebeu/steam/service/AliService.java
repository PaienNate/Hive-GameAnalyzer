package edu.hebeu.steam.service;

import com.alipay.api.AlipayApiException;
import com.baomidou.mybatisplus.extension.service.IService;
import edu.hebeu.steam.common.page.PageRequest;
import edu.hebeu.steam.common.page.PageResult;
import edu.hebeu.steam.pojo.Login.LoginBean;
import edu.hebeu.steam.pojo.alipay.SysPay;

public interface AliService extends IService<SysPay> {
    PageResult findPage(PageRequest pageRequest);
    String CreateAliPayTask(LoginBean loginBean) throws AlipayApiException;
}
