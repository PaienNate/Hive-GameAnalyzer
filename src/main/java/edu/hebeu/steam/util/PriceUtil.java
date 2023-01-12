package edu.hebeu.steam.util;

import java.util.HashMap;
import java.util.Map;

public class PriceUtil {

    public static String createPrice(double sale){
        String evaluate = "";
        if(sale<30){
            evaluate = "其价格亲民";
        }
        if(sale>30 && sale<80){
            evaluate = "其价格一般";
        }
        if(sale>80){
            evaluate = "其价格较贵";
        }
        return evaluate;
    }

}
