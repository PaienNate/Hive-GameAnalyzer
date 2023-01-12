package edu.hebeu.steam.service.impl;

import cn.hutool.core.util.NumberUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.hebeu.steam.mapper.DevEvaluateMapper;
import edu.hebeu.steam.pojo.hive.DevEvaluate;
import edu.hebeu.steam.service.DevEvaluateService;
import edu.hebeu.steam.util.AvgTimeUtil;
import edu.hebeu.steam.util.OwnerUtil;
import edu.hebeu.steam.util.PositiveUtil;
import edu.hebeu.steam.util.PriceUtil;
import org.springframework.stereotype.Service;

import javax.jdo.annotations.Cacheable;

@Service
@Cacheable
public class DevEvaluateServiceImpl extends ServiceImpl<DevEvaluateMapper, DevEvaluate> implements DevEvaluateService {

    @Override
    public String getCommentForDeveloper(String dev)
    {
        LambdaQueryWrapper<DevEvaluate> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(DevEvaluate::getDev, dev);
        DevEvaluate devConfig = new DevEvaluate();
        try
        {
            devConfig = baseMapper.selectList(wrapper).get(0);
        }
        catch (Exception e)
        {
            return "Failed";
        }
        StringBuilder builder = new StringBuilder();
        return builder
                .append("<span>")
                .append(devConfig.getDev())
                .append("</span>")
                .append("在2021年制作了如下游戏：")
                .append("<span>")
                .append(devConfig.getName())
                .append("</span>")
                .append("，平均拥有的用户数约为")
                .append("<span>")
                .append(NumberUtil.round(devConfig.getOwner(),2))
                .append("</span>")
                .append("，" + OwnerUtil.createOwner(devConfig.getOwner()))
                .append("<span>")
                .append("，根据发行游戏当前价格分析，其价格平均值为：")
                .append(NumberUtil.round(devConfig.getPrice(),2))
                .append("元</span>，")
                .append(PriceUtil.createPrice(devConfig.getPrice()))
                .append("<span>")
                .append("对所有游戏进行平均时长统计，统计得到其所有游戏平均时长为：")
                .append(NumberUtil.round(devConfig.getAvgTime(),2))
                .append("分钟，</span>")
                .append(AvgTimeUtil.createTime(devConfig.getAvgTime()))
                .append("<span>")
                .append("玩过其游戏的用户们，对游戏的评价统合后，计算得到其平均好评率为：")
                .append(NumberUtil.round(devConfig.getAvgPositive() * 100,2))
                .append("%</span>")
                .append(PositiveUtil.createPositive(devConfig.getAvgPositive()))
                .append("，在2021年度，该开发商最受好评的游戏是")
                .append("<span>")
                .append(devConfig.getPoname())
                .append("</span>")
                .append(",该游戏的好评率为：")
                .append(NumberUtil.round(devConfig.getPovalue() * 100,2)+"%,如果喜欢的话可以考虑入手一份。").toString();
    }




}
