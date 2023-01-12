package edu.hebeu.steam.pojo.viewdata;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class EvolveFork {
    /**
     * chartData
     */
    @JSONField(name = "chartData")
    private List<List<String>> chartData;
    /**
     * playerList
     */
    @JSONField(name = "playerList")
    private List<String> playerList;
    /**
     * roomNum
     */
    @JSONField(name = "roomNum")
    private Integer roomNum;

    /**
     * roomNum
     */
    @JSONField(name = "playerNum")
    private Integer playerNum;


}
