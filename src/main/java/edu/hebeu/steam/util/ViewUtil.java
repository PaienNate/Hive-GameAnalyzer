package edu.hebeu.steam.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ViewUtil {

    public static Map<String,String> createItemStyle(String color){
        Map<String,String> map = new HashMap<>();
        map.put("color", color);
        return map;
    }
    public static Map<String,String> createItemStyle()
    {
        return createItemStyle(getRandomColor());
    }







        public static String getRandomColor()
        {
            //红色
            String red;
            //绿色
            String green;
            //蓝色
            String blue;
            //生成随机对象
            Random random = new Random();
            //生成红色颜色代码
            red = Integer.toHexString(random.nextInt(156)+100).toUpperCase();
            //生成绿色颜色代码
            green = Integer.toHexString(random.nextInt(156)+100).toUpperCase();
            //生成蓝色颜色代码
            blue = Integer.toHexString(random.nextInt(156)+100).toUpperCase();

            //判断红色代码的位数
            red = red.length()==1 ? "0" + red : red ;
            //判断绿色代码的位数
            green = green.length()==1 ? "0" + green : green ;
            //判断蓝色代码的位数
            blue = blue.length()==1 ? "0" + blue : blue ;
            //生成十六进制颜色值
            String color = "#"+red+green+blue;
            System.out.println(color);
            return color;
        }


}
