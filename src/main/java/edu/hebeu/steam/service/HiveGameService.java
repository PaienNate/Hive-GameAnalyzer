package edu.hebeu.steam.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.hebeu.steam.pojo.Base2PojoExtend;
import edu.hebeu.steam.pojo.Language;
import edu.hebeu.steam.pojo.hive.HiveGame;
import edu.hebeu.steam.pojo.viewdata.*;

import java.util.List;

public interface HiveGameService extends IService<HiveGame> {
    public String testHiveGame();


    //饼图获取Steam开发者游戏标签和游戏数量
    List<PieVO> getSteamTagAndCount();

    //饼图获取Steam开发者游戏标签和游戏数量(最低)
    List<PieVO> getSteamBadTagAndCount();

    //使用Forest获取游戏的详细信息
    Base2PojoExtend getSteamGameDetails(String appid);

    //表格获取“多个”（20）最多拥有人数的游戏的列表
    HotChartsVO getMostOwnerGame(String num);

    List<DeveloperTable> getGameDetailsFromDeveloperButUseAppid(String developer);

    List<DeveloperTable> getGameNameFromGenreButPositive(String developer);

    List<Base2Pojo> getTop100ForWordCloud();

    Language getLanguageCompare();

    List<Base2Pojo> getDropPicForPositive(int appid);

    //表格获取“多个”（20）最多拥有人数的游戏的列平均在线时长
    HotChartsVO getMostMedianGame(String num);
}
