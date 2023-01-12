package edu.hebeu.steam.controller;

import edu.hebeu.steam.annotation.Log;
import edu.hebeu.steam.common.page.PageRequest;
import edu.hebeu.steam.common.result.CommonResult;
import edu.hebeu.steam.pojo.Sys.SysCheckPasswd;
import edu.hebeu.steam.pojo.Sys.SysUser;
import edu.hebeu.steam.service.UserService;
import edu.hebeu.steam.util.baseutil.PasswordUtil;
import edu.hebeu.steam.util.XString;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;




    @Log("新增/修改用户")
    @PostMapping(value="/save")
    public CommonResult save(@RequestBody SysUser record) {
        SysUser user = userService.findById(record.getId());
        if(user != null) {
            if("admin".equalsIgnoreCase(user.getName())) {
                return CommonResult.error("超级管理员不允许修改!");
            }
        }
        if(record.getPassword() != null) {
            if(user == null) {
                // 新增用户
                if(userService.findByName(record.getName()) != null) {
                    return CommonResult.error("用户名已存在!");
                }
                PasswordUtil.encryptPassword(record);
            } else {
                // 修改用户, 且修改了密码
                if(!record.getPassword().equals(user.getPassword())) {
                    PasswordUtil.encryptPassword(record);
                }
            }
        }
        return CommonResult.success(userService.save(record));
    }

    @Log("删除用户")
    @PostMapping(value="/delete")
    public CommonResult delete(@RequestBody List<SysUser> records) {
        for(SysUser record : records) {
            SysUser sysUser = userService.findById(record.getId());
            if(sysUser != null && "admin".equalsIgnoreCase(sysUser.getName())) {
                return CommonResult.error("超级管理员不允许删除!");
            }
        }
        return CommonResult.success(userService.delete(records));
    }

    @GetMapping(value="/findByName")
    public CommonResult findByUserName(@RequestParam String name) {
        return CommonResult.success(userService.findByName(name));
    }

    @Log("查看用户")
    @PostMapping(value="/findPage")
    public CommonResult findPage(@RequestBody PageRequest pageRequest) {
        return CommonResult.success(userService.findPage(pageRequest));
    }

    @Log("请求验证码")
    @ApiOperation(value = "用户-找回密码验证码获取",notes ="传入email。" )
    @RequestMapping(value = "/resetPasswd", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult resetPasswd(@RequestBody SysUser user) throws Exception {
        String email = user.getEmail();
        if (XString.isEmail(email)) {
            if (userService.sendPasswdReset(email)) {
                //发送邮件成功，给前端200
                return CommonResult.success("成功");
            }
            return CommonResult.error("发送失败请联系管理员！");
        }
        return CommonResult.error("邮箱不正确！");
    }
    @Log("修改密码")
    @RequestMapping(value = "/modifyPasswd", method = RequestMethod.POST)
    @ApiOperation(value = "用户-修改密码接口",notes ="用户带验证码和新密码请求可以修改密码" )
    public CommonResult modifyPasswd(@RequestBody SysCheckPasswd checkPasswd)
    {
        String verifycode = checkPasswd.getVerify();
        String email = userService.checkCodeValid(verifycode);
        if (email != null) {
            try{
                //加密工作已经在后台做了
                userService.beginPasswdReset(email,checkPasswd.getNewpass());
                return CommonResult.success("修改密码成功，请使用新密码登录");
            } catch (Exception e) {
                CommonResult.error("错误，请检查后台");
                e.printStackTrace();
            }
        }
        return CommonResult.error("验证码错误或过期！");
    }
}
