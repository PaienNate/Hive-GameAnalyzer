package edu.hebeu.steam.mapper;

import com.alibaba.fastjson.JSONObject;
import com.dtflys.forest.annotation.Get;
import edu.hebeu.steam.common.forest.Proxy;
import edu.hebeu.steam.pojo.hive.GameData;


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

        @Get(
                url = "http://112.126.67.230:5011/get/?type=https",
                dataType = "json"
        )
        Proxy getProxy();

}
