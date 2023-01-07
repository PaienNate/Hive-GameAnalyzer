package edu.hebeu.steam.viewdata;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class HotChartsVO {
    @JSONField(name = "head")
    private List<HeadDTO> head;
    @JSONField(name = "model")
    private List<ModelDTO> model;

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class HeadDTO {
        @JSONField(name = "label")
        private String label;
        @JSONField(name = "span")
        private Integer span;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class ModelDTO {
        @JSONField(name = "appid")
        private Integer appid;
        @JSONField(name = "appname")
        private String appname;
        @JSONField(name = "value")
        private String value;
    }
}
