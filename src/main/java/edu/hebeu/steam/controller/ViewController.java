package edu.hebeu.steam.controller;

import edu.hebeu.steam.annotation.Log;
import edu.hebeu.steam.common.result.CommonResult;
import edu.hebeu.steam.service.HiveGameService;
import edu.hebeu.steam.viewdata.HotChartsVO;
import edu.hebeu.steam.viewdata.PieVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("//fruit")
public class ViewController {

    @Autowired
    HiveGameService hiveGameService;

    @GetMapping("/getHighestGenre")
    @Log("获取游戏最高十个类别及数量")
    public CommonResult getHighVO(){
        return CommonResult.success("获取成功",hiveGameService.getSteamTagAndCount());
    }

    @GetMapping("/getLowestGenre")
    @Log("获取游戏最高十个类别及数量")
    public CommonResult getLowVO(){
        return CommonResult.success("获取成功",hiveGameService.getSteamBadTagAndCount());
    }

    @GetMapping("/getOwnerMostTime")
    @Log("获取游戏拥有者前十的平均游玩时长")
    public CommonResult getOwnerMostTimeVO(){
        HotChartsVO map = hiveGameService.getMostOwnerGame("20");
        return CommonResult.success("获取成功", map);
    }
    @GetMapping("/getDetails")
    @Log("查看游戏详细信息")
    public CommonResult getDetails(@RequestParam String appid)
    {
        return CommonResult.success("获取成功",hiveGameService.getSteamGameDetails(appid));
    }
    @GetMapping("/getGameFromDeveloper")
    @Log("通过开发者查看其开发的游戏信息")
    public CommonResult getGameDetailsFromDeveloper(@RequestParam String developer)
    {
        return CommonResult.success("获取成功",hiveGameService.getGameDetailsFromDeveloper(developer));
    }
    @GetMapping("/getGameNameFromGenreButPositive")
    @Log("通过标签查询游戏名但按照好评数量排列")
    public CommonResult getGameNameFromGenreButPositive(@RequestParam String developer)
    {
        return CommonResult.success("获取成功",hiveGameService.getGameNameFromGenreButPositive(developer));
    }

}
