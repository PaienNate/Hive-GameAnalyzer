package edu.hebeu.steam.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.hebeu.steam.pojo.HiveGame;
import edu.hebeu.steam.pojo.SteamGameDetails;
import edu.hebeu.steam.pojo.SysMenu;
import edu.hebeu.steam.viewdata.DeveloperTable;
import edu.hebeu.steam.viewdata.HotChartsVO;
import edu.hebeu.steam.viewdata.PieVO;

import java.util.List;

public interface HiveGameService extends IService<HiveGame> {
    public String testHiveGame();


    //饼图获取Steam开发者游戏标签和游戏数量
    List<PieVO> getSteamTagAndCount();

    //饼图获取Steam开发者游戏标签和游戏数量(最低)
    List<PieVO> getSteamBadTagAndCount();

    //使用Forest获取游戏的详细信息
    SteamGameDetails getSteamGameDetails(String appid);

    //表格获取“多个”（20）最多拥有人数的游戏的列表
    HotChartsVO getMostOwnerGame(String num);

    List<DeveloperTable> getGameDetailsFromDeveloper(String developer);

    List<DeveloperTable> getGameNameFromGenreButPositive(String developer);
}
