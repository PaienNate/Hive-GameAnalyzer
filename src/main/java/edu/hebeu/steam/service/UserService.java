package edu.hebeu.steam.service;


import com.baomidou.mybatisplus.extension.service.IService;
import edu.hebeu.steam.common.page.PageRequest;
import edu.hebeu.steam.common.page.PageResult;
import edu.hebeu.steam.pojo.Sys.SysUser;

import java.util.List;

public interface UserService extends IService<SysUser> {

    PageResult findPage(PageRequest pageRequest);


    int delete(List<SysUser> users);

    /**
     * 获取指定用户ID对应的用户账户信息
     * @param userId 用户ID
     * @return 返回用户账户信息
     */
    SysUser findById(Long userId);

    /**
     * 获取指定 userName 对应的用户账户信息
     * @param userName 用户名
     * @return 返回用户账户信息
     */
    SysUser findByName(String userName);


    void updateLoginTime(SysUser user);

    /**
     * 添加一条用户账户信息
     * @param user 需要添加的用户账户信息
     */
    void createUser(SysUser user);

    //处理邮件验证
    boolean sendPasswdReset(String email) throws Exception;

    boolean beginPasswdReset(String useremail,String newpass) throws Exception;

    String checkCodeValid(String code);



}
