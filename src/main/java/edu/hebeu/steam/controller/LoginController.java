package edu.hebeu.steam.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import edu.hebeu.steam.annotation.Log;
import edu.hebeu.steam.common.result.CommonResult;
import edu.hebeu.steam.pojo.JWTToken;
import edu.hebeu.steam.pojo.LoginBean;
import edu.hebeu.steam.pojo.RegisterBean;
import edu.hebeu.steam.pojo.SysUser;
import edu.hebeu.steam.service.HiveGameService;
import edu.hebeu.steam.service.UserService;
import edu.hebeu.steam.util.DateUtil;
import edu.hebeu.steam.util.PasswordUtil;
import edu.hebeu.steam.util.TokenUtil;
import edu.hebeu.steam.util.XString;
import io.swagger.annotations.ApiOperation;
import jdk.nashorn.internal.parser.Token;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;


@RestController
@Slf4j
public class LoginController {
    @Autowired
    private Producer producer;
    @Autowired
    private UserService userService;
    @Autowired
    private HiveGameService hiveGameService;

    @GetMapping("captcha.jpg")
    public void captcha(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");
        // 生成文字验证码
        String text = producer.createText();
        // 生成图片验证码
        BufferedImage image = producer.createImage(text);
        // 保存到验证码到 session
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, text);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        out.close();
    }
    @Log("用户注册")
    @ApiOperation(value = "用户-注册",notes ="传入用户名，密码，昵称进行注册" )
    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult regist(@RequestBody RegisterBean registerBean
    ) {
        String psw = registerBean.getPassword();
        String name = registerBean.getName();
        String email = registerBean.getEmail();
        //密码若非空
        if(email==null)
        {
            return CommonResult.error("没有邮箱无法注册！");
        }
        if(!XString.isEmail(email))
        {
            return CommonResult.error("邮箱格式不正确！");
        }
        //验证名字
        if(name.equals(""))
        {
            return CommonResult.error("请填写用户名！");
        }
        if(psw!= null)
        {
            //根据名称确定是否可注册
                if(userService.findByName(name) != null) {
                    return CommonResult.error("用户名已存在!");
                }
                //否则加密密码
                SysUser user = new SysUser();
                user.setName(name);
                user.setPassword(psw);
                user.setEmail(email);
                PasswordUtil.encryptPassword(user);
                user.setCreateTime(new Date());
                //返回成功
                return CommonResult.success(userService.save(user));
        }
        else
        {
            return CommonResult.error("密码为空");
        }
    }
    @Log("用户登录")
    @ApiOperation(value = "用户-登录",notes ="传入用户名和密码进行登录" )
    @PostMapping(value = "/user/login")
    @ResponseBody
    public CommonResult userlogin(@RequestBody LoginBean loginBean, HttpServletRequest request) {
        //String a = hiveGameService.testHiveGame();
        //System.out.println(a);
        String username = loginBean.getName();
        String password = loginBean.getPassword();
        String captcha = loginBean.getCaptcha();
        Object kaptcha = request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if(kaptcha == null){
            return CommonResult.error("验证码已失效");
        }
        if(!captcha.equals(kaptcha)){
            return CommonResult.error("验证码不正确");
        }
        //搜索用户
        SysUser user = userService.findByName(username);
        //用户为空不存在
        if (user == null) {
            return CommonResult.error("用户名不存在");
        }
        //加盐
        String passwdWithSalt = PasswordUtil.encryptPassword(password, user.getSalt());
        //输出密码
        System.out.println("当前密码是" + user.getPassword() +"分割"+ passwdWithSalt);
        if (!StringUtils.equals(user.getPassword(), passwdWithSalt)) {
            return CommonResult.error("密码错误");
        }
        //更新登录时间
        userService.updateLoginTime(user);
        //设置登录token
        String token = TokenUtil.sign(username, passwdWithSalt);
        //过期时间默认已经设置
        String expireTimeStr = DateUtil.formatFullTime(LocalDateTime.now().plusHours(3));
        JWTToken jwtToken = new JWTToken(token, expireTimeStr);
        Map<String, Object> map = new HashMap<>();
        //推送token验证
        map.put("token", jwtToken.getToken());
        //成功登录
        return CommonResult.success("登录成功", map);
    }

    @PostMapping("login")
    public CommonResult login(@RequestBody LoginBean loginBean, HttpServletRequest request) {
        String username = loginBean.getName();
        String password = loginBean.getPassword();
        String captcha = loginBean.getCaptcha();
        // 从session中获取之前保存的验证码跟前台传来的验证码进行匹配
        Object kaptcha = request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if(kaptcha == null){
            return CommonResult.error("验证码已失效");
        }
        if(!captcha.equals(kaptcha)){
            return CommonResult.error("验证码不正确");
        }
        //搜索用户
        SysUser user = userService.findByName(username);
        //用户为空不存在
        if (user == null) {
            return CommonResult.error("用户名不存在");
        }
        //加盐
        String passwdWithSalt = PasswordUtil.encryptPassword(password, user.getSalt());
        //输出密码
        System.out.println("当前密码是" + user.getPassword() +"分割"+ passwdWithSalt);
        if (!StringUtils.equals(user.getPassword(), passwdWithSalt)) {
            return CommonResult.error("密码错误");
        }
        //更新登录时间
        userService.updateLoginTime(user);
        //设置登录token
        String token = TokenUtil.sign(username, passwdWithSalt);
        //过期时间默认已经设置
        String expireTimeStr = DateUtil.formatFullTime(LocalDateTime.now().plusHours(3));
        JWTToken jwtToken = new JWTToken(token, expireTimeStr);
        Map<String, Object> map = new HashMap<>();
        //推送token验证
        map.put("token", jwtToken.getToken());
        //成功登录
        return CommonResult.success("登录成功", map);
    }

    @Log("登出")
    @GetMapping("/logout")
    public CommonResult logout() {
        return CommonResult.success("登出成功");
    }
}
