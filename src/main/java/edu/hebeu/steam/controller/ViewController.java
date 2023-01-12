package edu.hebeu.steam.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.NumberUtil;
import edu.hebeu.steam.annotation.Log;
import edu.hebeu.steam.common.result.CommonResult;
import edu.hebeu.steam.pojo.viewdata.Base2Pojo;
import edu.hebeu.steam.service.DevEvaluateService;
import edu.hebeu.steam.service.HiveGameService;
import edu.hebeu.steam.pojo.viewdata.HotChartsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("//fruit")
public class ViewController {

    @Autowired
    HiveGameService hiveGameService;

    @Autowired
    DevEvaluateService devEvaluateService;

    @GetMapping("/getHighestGenre")
    @Log("获取游戏最高十个类别及数量")
    public CommonResult getHighVO(){
        return CommonResult.success("获取成功",hiveGameService.getSteamTagAndCount());
    }

    @GetMapping("/getLowestGenre")
    @Log("获取游戏最低十个类别及数量")
    public CommonResult getLowVO(){
        return CommonResult.success("获取成功",hiveGameService.getSteamBadTagAndCount());
    }

    @GetMapping("/getOwnerMostTime")
    //两个表格
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
    public CommonResult getGameDetailsFromDeveloper(@RequestParam String appid)
    {
        return CommonResult.success("获取成功",hiveGameService.getGameDetailsFromDeveloperButUseAppid(appid));
    }
    @GetMapping("/getGameNameFromGenreButPositive")
    @Log("通过标签查询游戏名但按照好评数量排列")
    public CommonResult getGameNameFromGenreButPositive(@RequestParam String developer)
    {
        return CommonResult.success("获取成功",hiveGameService.getGameNameFromGenreButPositive(developer));
    }

    @GetMapping("/getWordCloud")
    @Log("获取前一百的词云")
    public CommonResult getTop100TagsForWordCloud()
    {
        return CommonResult.success("获取成功",hiveGameService.getTop100ForWordCloud());
    }

    @GetMapping("getLanguageCompare")
    @Log("获取语言对比")
    public CommonResult getLanguageCompare()
    {
        return CommonResult.success("获取成功",hiveGameService.getLanguageCompare());
    }
    @GetMapping("getDropPicForPositive")
    @Log("读取好评率水滴图")
    public CommonResult getDropPicForPositive(@RequestParam int appid)
    {
        List<Base2Pojo> pojo =  hiveGameService.getDropPicForPositive(appid);
        List<Double> doubles = new ArrayList<>();
        if(pojo==null)
            return CommonResult.error("该游戏数据暂未收录！");

        for(Base2Pojo poj:pojo)
        {
            doubles.add(NumberUtil.round(Double.parseDouble(poj.getValue()),2).doubleValue());
        }
        return CommonResult.success("获取成功",doubles);
    }
    @GetMapping("getVIPComment")
    @Log("获取大数据分析评价（VIP）")
    public CommonResult getVIPComment(@RequestParam String developer)
    {
        if(!StpUtil.isLogin())
        {
            return CommonResult.error("获取失败，仅登录用户可使用该功能");
        }
        else if(!StpUtil.hasPermission("user.vip"))
        {
            return CommonResult.error("该功能仅限付费用户，请充值！");
        }
        return CommonResult.success("获取成功",devEvaluateService.getCommentForDeveloper(developer));
    }
    @GetMapping("/getOwnerMedianTime")
    @Log("获取游戏拥有者前十的中位游玩时长")
    public CommonResult getMedianMostTimeVO(){
        HotChartsVO map = hiveGameService.getMostMedianGame("20");
        return CommonResult.success("获取成功", map);
    }



}
