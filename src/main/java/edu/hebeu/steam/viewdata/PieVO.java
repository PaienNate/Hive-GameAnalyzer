package edu.hebeu.steam.viewdata;

import lombok.Data;

import java.util.Map;

@Data
public class PieVO {
    private Integer value;
    private Map<String,String> itemStyle;
    private String name;
}
