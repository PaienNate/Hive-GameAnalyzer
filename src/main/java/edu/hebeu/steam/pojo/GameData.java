package edu.hebeu.steam.pojo;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class GameData {


    @JSONField(name = "appid")
    private Integer appid;
    @JSONField(name = "name")
    private String name;
    @JSONField(name = "developer")
    private String developer;
    @JSONField(name = "publisher")
    private String publisher;
    @JSONField(name = "score_rank")
    private String scoreRank;
    @JSONField(name = "positive")
    private Integer positive;
    @JSONField(name = "negative")
    private Integer negative;
    @JSONField(name = "userscore")
    private Integer userscore;
    @JSONField(name = "owners")
    private String owners;
    @JSONField(name = "average_forever")
    private Integer averageForever;
    @JSONField(name = "average_2weeks")
    private Integer average2weeks;
    @JSONField(name = "median_forever")
    private Integer medianForever;
    @JSONField(name = "median_2weeks")
    private Integer median2weeks;
    @JSONField(name = "price")
    private String price;
    @JSONField(name = "initialprice")
    private String initialprice;
    @JSONField(name = "discount")
    private String discount;
    @JSONField(name = "ccu")
    private Integer ccu;
    @JSONField(name = "languages")
    private String languages;
    @JSONField(name = "genre")
    private String genre;
    @JSONField(name = "tags")
    private Object tags;
}
