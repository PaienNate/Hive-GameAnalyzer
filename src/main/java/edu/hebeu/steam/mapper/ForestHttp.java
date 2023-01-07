package edu.hebeu.steam.mapper;

import com.alibaba.fastjson.JSONObject;
import com.dtflys.forest.annotation.Get;
import com.dtflys.forest.annotation.Var;
import edu.hebeu.steam.forest.Proxy;
import edu.hebeu.steam.forest.ProxyPool;
import edu.hebeu.steam.pojo.GameData;

import java.util.Map;



public interface ForestHttp {
        @Get(
                url = "https://steamspy.com/api.php?request=appdetails&appid={0}",
                dataType = "json"
        )
        GameData getSteamSpyData(String appid);


        @Get(
                url = "https://store.steampowered.com/api/appdetails?appids={0}",
                dataType = "json"
        )
        JSONObject getGameDetails(String appid);
/*        @Get(
                url = "https://api.steampowered.com/ISteamNews/GetNewsForApp/v2/?appid={0}",
                dataType = "json"
        )*/






        @Get(
                url = "http://112.126.67.230:5011/get/?type=https",
                dataType = "json"
        )
        Proxy getProxy();

}
