package edu.hebeu.steam.viewdata;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class SteamNewsPojo {
    @JSONField(name = "appnews")
    private AppnewsDTO appnews;

    @NoArgsConstructor
    @Data
    public static class AppnewsDTO {
        @JSONField(name = "appid")
        private Integer appid;
        @JSONField(name = "newsitems")
        private List<NewsitemsDTO> newsitems;
        @JSONField(name = "count")
        private Integer count;

        @NoArgsConstructor
        @Data
        public static class NewsitemsDTO {
            @JSONField(name = "gid")
            private String gid;
            @JSONField(name = "title")
            private String title;
            @JSONField(name = "url")
            private String url;
            @JSONField(name = "is_external_url")
            private Boolean isExternalUrl;
            @JSONField(name = "author")
            private String author;
            @JSONField(name = "contents")
            private String contents;
            @JSONField(name = "feedlabel")
            private String feedlabel;
            @JSONField(name = "date")
            private Integer date;
            @JSONField(name = "feedname")
            private String feedname;
            @JSONField(name = "feed_type")
            private Integer feedType;
            @JSONField(name = "appid")
            private Integer appid;
            @JSONField(name = "tags")
            private List<String> tags;
        }
    }
}
