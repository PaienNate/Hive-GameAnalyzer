package edu.hebeu.steam.aspect;

import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import edu.hebeu.steam.annotation.LogAli;
import edu.hebeu.steam.pojo.Login.LoginBean;
import edu.hebeu.steam.pojo.Sys.SysUser;
import edu.hebeu.steam.pojo.alipay.AliReturnPay;
import edu.hebeu.steam.pojo.alipay.SysPay;
import edu.hebeu.steam.service.AliService;
import edu.hebeu.steam.service.UserService;
import edu.hebeu.steam.util.baseutil.HttpUtils;
import edu.hebeu.steam.util.baseutil.IPUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Slf4j
@Aspect
@Component
public class LogAspectAli {
    @Autowired
    private AliService aliService;
    @Autowired
    private UserService userService;

    @Pointcut("@annotation(edu.hebeu.steam.annotation.LogAli)")
    public void pointcut() {
        // do nothing
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Object result = null;
        long beginTime = System.currentTimeMillis();
        // 获取request
        HttpServletRequest request = HttpUtils.getHttpServletRequest();
        String ip = IPUtils.getIpAddr(request);
        // 执行方法
        result = point.proceed();
        // 执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;
        LoginBean loginBean = new LoginBean();
        loginBean.setName("未登录用户");
        // 使用这个获取LoginBean是可行的
        String loginjson = (String) StpUtil.getLoginIdDefaultNull();
        if(loginjson!=null)
        {
            loginBean = JSON.parseObject(loginjson,LoginBean.class);
        }
        // 保存日志
        String username = loginBean.getName();
        SysPay sysLog = new SysPay();
        //原装日志设置
        sysLog.setUserName(username);
        sysLog.setCreateBy(username);
        sysLog.setCreateTime(new Date());
        sysLog.setLastUpdateBy(username);
        sysLog.setLastUpdateTime(new Date());
        sysLog.setIp(ip);
        sysLog.setTime(time);
        //支付相关设置
        String className = point.getTarget().getClass().getName();
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        LogAli logAnnotation = method.getAnnotation(LogAli.class);
        if (logAnnotation != null) {
            // 注解上的描述
            sysLog.setOperation(logAnnotation.value());
        }
        String methodName = signature.getName();
        sysLog.setMethod(className + "." + methodName + "()");
        // 请求的方法参数值
        Object[] args = point.getArgs();
        try{
            String params = JSONObject.toJSONString(args[0]);
            if(args.length>1)
            {
                //是支付宝回调传参
                AliReturnPay returnPay = JSON.parseObject(params,AliReturnPay.class);
                String userid = returnPay.getOut_trade_no().split("%")[0];
                SysUser user = userService.findById(Long.parseLong(userid));
                user.setStatus((byte)1);
                //单独修改getName
                sysLog.setUserName(user.getName());
                sysLog.TransformReturnPay(returnPay);
            }

        } catch (Exception e){
        }
        aliService.save(sysLog);
        return result;
    }
}
