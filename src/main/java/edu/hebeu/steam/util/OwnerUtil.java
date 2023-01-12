package edu.hebeu.steam.util;

import java.util.HashMap;
import java.util.Map;

public class OwnerUtil {

    public static String createOwner(double sale){
        String evaluate = "";
        if(sale<10000){
            evaluate = "其受众较小";
        }
        if(sale>10000 && sale<500000){
            evaluate = "其受众一般";
        }
        if(sale>500000){
            evaluate = "其受众良好";
        }
        return evaluate;
    }

}
