package edu.hebeu.steam.mapper;

import com.alibaba.fastjson.JSONObject;
import com.dtflys.forest.annotation.Get;
import com.dtflys.forest.annotation.Var;
import edu.hebeu.steam.common.forest.Proxy;
import edu.hebeu.steam.common.forest.ProxyPool;
import edu.hebeu.steam.pojo.hive.GameData;


public interface ForestHttp {
        @Get(
                url = "https://steamspy.com/api.php?request=appdetails&appid={0}",
                dataType = "json"
        )
        GameData getSteamSpyData(String appid);

        @ProxyPool
        @Get(
                url = "https://steamspy.com/api.php?request=appdetails&appid={2}",
                dataType = "json"
        )
        GameData getSteamSpyData_proxy(@Var("host") String host, @Var("port") String port, String appid);


        @Get(
                url = "https://store.steampowered.com/api/appdetails?appids={0}",
                dataType = "json"
        )
        JSONObject getGameDetails(String appid);

        @Get(
                url = "http://111.111.111.111:5011/get/?type=https",
                dataType = "json"
        )
        Proxy getProxy();

}
