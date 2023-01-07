package edu.hebeu.steam.util;

import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

public class MD5Util {

    //这个是MD5加密的方法，是通过调用DigestUtils的md5Hex方法实现的
    public static String md5(String src) {
        return DigestUtils.md5DigestAsHex(src.getBytes(StandardCharsets.UTF_8));
    }

    //这是固定salt
    private static final String salt = "1a2b3c4d";

    //第一次MD5加密，为了进一步保证安全，会与固定salt中的字符进行自由的拼接
    public static String inputPassToFormPass(String inputPass) {
        String str = ""+salt.charAt(0)+salt.charAt(2) + inputPass +salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }

    //第二次MD5加密，这里传入第一次加密后得到的formPass，然后输入一个随机salt
    public static String formPassToDBPass(String formPass, String salt) {
        String str = ""+salt.charAt(0)+salt.charAt(2) + formPass +salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }

    //这个是可以直接进行两次加密的方法
    public static String inputPassToDbPass(String inputPass, String saltDB) {
        String formPass = inputPassToFormPass(inputPass);
        String dbPass = formPassToDBPass(formPass, saltDB);
        return dbPass;
    }

    public static void main(String[] args) {

        //这是一个测试
        System.out.println(inputPassToFormPass("123456"));//d3b1294a61a07da9b49b6e22b2cbd7f9
        System.out.println(formPassToDBPass(inputPassToFormPass("123456"), "1a2b3c4d"));
        System.out.println(inputPassToDbPass("123456", "1a2b3c4d"));//b7797cce01b4b131b433b6acf4add449
    }
}
