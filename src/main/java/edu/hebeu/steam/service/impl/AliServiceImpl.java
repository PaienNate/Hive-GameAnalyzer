package edu.hebeu.steam.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.hebeu.steam.common.page.ColumnFilter;
import edu.hebeu.steam.common.page.PageRequest;
import edu.hebeu.steam.common.page.PageResult;
import edu.hebeu.steam.mapper.AliMapper;
import edu.hebeu.steam.mapper.UserMapper;
import edu.hebeu.steam.pojo.Login.LoginBean;
import edu.hebeu.steam.pojo.Sys.SysUser;
import edu.hebeu.steam.pojo.alipay.AliSend;
import edu.hebeu.steam.pojo.alipay.SysPay;
import edu.hebeu.steam.service.AliService;
import edu.hebeu.steam.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static edu.hebeu.steam.common.config.AliConfig.*;
@Service
public class AliServiceImpl extends ServiceImpl<AliMapper, SysPay> implements AliService  {
    @Autowired
    AliMapper aliMapper;
    @Autowired
    UserService userService;



    @Override
    public PageResult findPage(PageRequest pageRequest) {
        ColumnFilter columnFilter = pageRequest.getColumnFilters().get("userName");
        LambdaQueryWrapper<SysPay> wrapper = new LambdaQueryWrapper<>();
        if (columnFilter != null && !StringUtils.isEmpty(columnFilter.getValue())) {
            wrapper.eq(SysPay::getUserName, columnFilter.getValue());
        }
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        Page<SysPay> page = new Page<>(pageNum, pageSize);
        IPage<SysPay> result = baseMapper.selectPage(page, wrapper);
        return new PageResult(result);
    }






    @Override
    public String CreateAliPayTask(LoginBean loginBean) throws AlipayApiException {
        //总之是要获取user的相关信息
        AlipayClient alipayClient = new DefaultAlipayClient(URL,APP_ID,APP_PRIVATE_KEY,FORMAT,CHARSET,ALIPAY_PUBLIC_KEY,SIGN_TYPE);
        AlipayTradePrecreateRequest alipayRequest = new AlipayTradePrecreateRequest();
        // 设置支付宝异步通知回调地址
        alipayRequest.setNotifyUrl(NOTIFY_URL);
        AliSend send = new AliSend();
        //预留以后修改的接口
        //send.setOutTradeNo(IdUtil.randomUUID());
        SysUser user = userService.findByName(loginBean.getName());
        String encrypt = user.getId() + "%" + IdUtil.randomUUID();
        send.setOutTradeNo(encrypt);
        send.setSubject("sandbox应用:2088621993981307 - 查看开发者大数据分析报告");
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
