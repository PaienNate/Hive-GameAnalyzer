package edu.hebeu.steam.util.baseutil;

import edu.hebeu.steam.pojo.Sys.SysUser;

import static edu.hebeu.steam.util.baseutil.MD5Util.inputPassToDbPass;

/**
 * @Author 10319
 * @Date 2019/6/13 22:10
 * @Version 1.0
 */
public class PasswordUtil {

    /**
     * 使用盐加密密码
     * @param user
     */
    public static void encryptPassword(SysUser user){
        // 设置盐
        user.setSalt("1a2b3c4d");
        //将用户的注册密码经过散列算法替换成一个不可逆的新密码保存进数据，使用过程使用了盐
        String newPassword = inputPassToDbPass(user.getPassword(),user.getSalt());
        //String newPassword = new SimpleHash(algorithmName, user.getPassword(), salt, hashIterations).toString();
        user.setPassword(newPassword);
    }

    public static String encryptPassword(String password, String salt){
        //将用户的注册密码经过散列算法替换成一个不可逆的新密码保存进数据，使用过程使用了盐
        String newPassword = inputPassToDbPass(password,salt);
        return newPassword;
    }

}
