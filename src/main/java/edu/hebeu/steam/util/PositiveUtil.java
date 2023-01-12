package edu.hebeu.steam.util;

import java.util.HashMap;
import java.util.Map;

public class PositiveUtil {

    public static String createPositive(double sale){
        String evaluate = "";
        if(sale<0.5){
            evaluate = "其好评率较低";
        }
        if(sale>0.5 && sale<0.8){
            evaluate = "其好评率一般";
        }
        if(sale>0.8){
            evaluate = "其好评率良好";
        }
        return evaluate;
    }

}
