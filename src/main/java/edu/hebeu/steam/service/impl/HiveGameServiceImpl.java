package edu.hebeu.steam.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.hebeu.steam.mapper.*;
import edu.hebeu.steam.pojo.*;
import edu.hebeu.steam.service.HiveGameService;
import edu.hebeu.steam.util.ViewUtil;
import edu.hebeu.steam.viewdata.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class HiveGameServiceImpl extends ServiceImpl<HiveMapper, HiveGame> implements HiveGameService {
/*    @Autowired
    HiveMapper hiveMapper;*/
        @Resource
        private ForestHttp myClient;
        @Resource
        private GameIDMapper gameIDMapper;
        @Resource
        private GameMapper gameMapper;
        @Resource
        private HiveMapper hiveMapper;

    @Override
    public String testHiveGame() {
        int count = gameIDMapper.selectCount(null);
        int now = 0;
        //获取所有的APPID用以使用
        for(Data data:gameIDMapper.selectList(null))
        {
            try{
                double a = 1.0 * now/count * 100;
                System.out.println("当前处理的APPID为" + data.getAppid() + "完成进度为" + a + "%");
                System.out.println("处理了共计" + now + "条数据！");
                GameData map = myClient.getSteamSpyData(data.getAppid());
                //GameData map = myClient.getSteamSpyData(String.valueOf(417360));
                //判断是否需要输入空
                boolean isJsonObject = false;
                try
                {
                    JSONArray bodyJson = (JSONArray)map.getTags();
                }
                catch (ClassCastException e)
                {
                    System.out.println("当前是JSONObject!");
                    //报错说明是json
                    isJsonObject = true;
                }
                //把对应的数据传输进去
                Gamedata2 gameData = new Gamedata2();
                gameData.setAppid(map.getAppid());
                gameData.setName(map.getName());
                gameData.setDeveloper(map.getDeveloper());
                gameData.setScore_rank(map.getScoreRank());
                gameData.setPositive(map.getPositive());
                gameData.setNegative(map.getNegative());
                gameData.setUserscore(map.getUserscore().toString());
                gameData.setOwners(map.getOwners());
                gameData.setAverage_forever(map.getAverageForever());
                gameData.setAverage_2weeks(map.getAverage2weeks());
                gameData.setMedian_2weeks(map.getMedian2weeks());
                gameData.setMedian_forever(map.getMedianForever());
                gameData.setPrice(Double.parseDouble(map.getPrice()));
                gameData.setInitialprice(Double.parseDouble(map.getInitialprice()));
                gameData.setDiscount(Integer.parseInt(map.getDiscount()));
                gameData.setCcu(map.getCcu());
                gameData.setLanguages(map.getLanguages());
                gameData.setGenre(map.getGenre());
                StringBuilder builder = new StringBuilder();
                if(isJsonObject)
                {
                    //转换为jsonObject
                    JSONObject jsonObject = (JSONObject) JSON.toJSON(map.getTags());
                for(String key:jsonObject.keySet())
                {
                    builder.append(key);
                    builder.append(",");
                }
                }
                else
                {
                    builder.append(" ");
                }
                gameData.setTags(builder.append("狗").toString().replace(",狗",""));
                gameMapper.insert(gameData);
                TimeUnit.SECONDS.sleep(2);
                System.out.println("请求完毕，等待完毕，准备下一个");
                now++;
                }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        return "";
    }
    //饼图获取Steam开发者游戏标签和游戏数量(最高)
    @Override
    public List<PieVO> getSteamTagAndCount()
    {
        try
        {
        List<PieVO> pieVOList = new ArrayList<>();
        List<Base2Pojo> nv = hiveMapper.getGenreAndvalue();
        for(Base2Pojo pojo: nv)
        {
            PieVO pieVO = new PieVO();
            pieVO.setName(pojo.getName());
            pieVO.setValue(Integer.parseInt(pojo.getValue()));
            pieVO.setItemStyle(ViewUtil.createItemStyle());
            pieVOList.add(pieVO);
        }
        return pieVOList;
        }
        catch (Exception e)
        {
            return null;
        }
    }

    //饼图获取Steam开发者游戏标签和游戏数量(最低)
    @Override
    public List<PieVO> getSteamBadTagAndCount()
    {
        try
        {
            List<PieVO> pieVOList = new ArrayList<>();
            List<Base2Pojo> nv = hiveMapper.getBadGenreAndvalue();
            for(Base2Pojo pojo: nv)
            {
                PieVO pieVO = new PieVO();
                if(pojo.getName().equals(""))
                {
                    pojo.setName("未贴标签");
                }
                pieVO.setName(pojo.getName());
                pieVO.setValue(Integer.parseInt(pojo.getValue()));
                pieVO.setItemStyle(ViewUtil.createItemStyle());
                pieVOList.add(pieVO);
            }
            return pieVOList;
        }
        catch (Exception e)
        {
            return null;
        }
    }
    //使用Forest获取游戏的详细信息
    @Override
    public SteamGameDetails getSteamGameDetails(String appid)
    {
        JSONObject object = myClient.getGameDetails(appid);
        System.out.println(object.get(appid));
        System.out.println(JSONObject.toJSON(object.get(appid)));
        return JSONObject.toJavaObject((JSONObject)JSONObject.toJSON(object.get(appid)),SteamGameDetails.class);
    }





    //表格获取“多个”（20）最多拥有人数的游戏的列表
    @Override
    public HotChartsVO getMostOwnerGame(String num)
    {
        HotChartsVO hotChartsVO = new HotChartsVO();
        List<MostOwnerGamePojo> mostOwnerGamePojoList= hiveMapper.getMostOwnerGame(num);
        List<HotChartsVO.HeadDTO> headDTOList = new ArrayList<>();
        headDTOList.add(new HotChartsVO.HeadDTO("游戏拥有最多人数",2));
        headDTOList.add(new HotChartsVO.HeadDTO("平均游玩时长",1));
        List<HotChartsVO.ModelDTO> modelDTOList = new ArrayList<>();
        for(MostOwnerGamePojo pojo : mostOwnerGamePojoList)
        {
            int t = pojo.getValue();
            int hours = t / 60; //since both are ints, you get an int
            int minutes = t % 60;
            String a = hours + "小时" + minutes + "分钟";
            modelDTOList.add(new HotChartsVO.ModelDTO(pojo.getAppid(),pojo.getName(),a));
        }
        hotChartsVO.setHead(headDTOList);
        hotChartsVO.setModel(modelDTOList);
        return hotChartsVO;
    }
@Override
    public List<DeveloperTable> getGameDetailsFromDeveloper(String developer)
    {
        return hiveMapper.getDeveloperDetail(developer);
    }

    @Override
    public List<DeveloperTable> getGameNameFromGenreButPositive(String developer)
    {
        return hiveMapper.getGenreDetail(developer);
    }


}
