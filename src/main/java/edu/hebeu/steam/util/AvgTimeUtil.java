package edu.hebeu.steam.util;

import java.util.HashMap;
import java.util.Map;

public class AvgTimeUtil {

    public static String createTime(double sale){
        String evaluate = "";
        if(sale<200){
            evaluate = "其用户黏度较低";
        }
        if(sale>200 && sale<500){
            evaluate = "其用户黏度一般";
        }
        if(sale>500){
            evaluate = "其用户黏度良好";
        }
        return evaluate;
    }

}
