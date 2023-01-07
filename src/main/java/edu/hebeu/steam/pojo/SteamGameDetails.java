package edu.hebeu.steam.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class SteamGameDetails{
    @JSONField(name = "success")
    private Boolean success;
    @JSONField(name = "data")
    private DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
        @JSONField(name = "type")
        private String type;
        @JSONField(name = "name")
        private String name;
        @JSONField(name = "steam_appid")
        private Integer steamAppid;
        @JSONField(name = "required_age")
        private Integer requiredAge;
        @JSONField(name = "is_free")
        private Boolean isFree;
        @JSONField(name = "controller_support")
        private String controllerSupport;
        @JSONField(name = "detailed_description")
        private String detailedDescription;
        @JSONField(name = "about_the_game")
        private String aboutTheGame;
        @JSONField(name = "short_description")
        private String shortDescription;
        @JSONField(name = "supported_languages")
        private String supportedLanguages;
        @JSONField(name = "header_image")
        private String headerImage;
        @JSONField(name = "website")
        private String website;
        @JSONField(name = "pc_requirements")
        private PcRequirementsDTO pcRequirements;
        @JSONField(name = "mac_requirements")
        private MacRequirementsDTO macRequirements;
        @JSONField(name = "linux_requirements")
        private LinuxRequirementsDTO linuxRequirements;
        @JSONField(name = "developers")
        private List<String> developers;
        @JSONField(name = "publishers")
        private List<String> publishers;
        @JSONField(name = "packages")
        private List<Integer> packages;
        @JSONField(name = "package_groups")
        private List<PackageGroupsDTO> packageGroups;
        @JSONField(name = "platforms")
        private PlatformsDTO platforms;
        @JSONField(name = "metacritic")
        private MetacriticDTO metacritic;
        @JSONField(name = "categories")
        private List<CategoriesDTO> categories;
        @JSONField(name = "genres")
        private List<GenresDTO> genres;
        @JSONField(name = "screenshots")
        private List<ScreenshotsDTO> screenshots;
        @JSONField(name = "movies")
        private List<MoviesDTO> movies;
        @JSONField(name = "recommendations")
        private RecommendationsDTO recommendations;
        @JSONField(name = "achievements")
        private AchievementsDTO achievements;
        @JSONField(name = "release_date")
        private ReleaseDateDTO releaseDate;
        @JSONField(name = "support_info")
        private SupportInfoDTO supportInfo;
        @JSONField(name = "background")
        private String background;
        @JSONField(name = "background_raw")
        private String backgroundRaw;
        @JSONField(name = "content_descriptors")
        private ContentDescriptorsDTO contentDescriptors;

        @NoArgsConstructor
        @Data
        public static class PcRequirementsDTO {
            @JSONField(name = "minimum")
            private String minimum;
        }

        @NoArgsConstructor
        @Data
        public static class MacRequirementsDTO {
            @JSONField(name = "minimum")
            private String minimum;
        }

        @NoArgsConstructor
        @Data
        public static class LinuxRequirementsDTO {
            @JSONField(name = "minimum")
            private String minimum;
        }

        @NoArgsConstructor
        @Data
        public static class PlatformsDTO {
            @JSONField(name = "windows")
            private Boolean windows;
            @JSONField(name = "mac")
            private Boolean mac;
            @JSONField(name = "linux")
            private Boolean linux;
        }

        @NoArgsConstructor
        @Data
        public static class MetacriticDTO {
            @JSONField(name = "score")
            private Integer score;
            @JSONField(name = "url")
            private String url;
        }

        @NoArgsConstructor
        @Data
        public static class RecommendationsDTO {
            @JSONField(name = "total")
            private Integer total;
        }

        @NoArgsConstructor
        @Data
        public static class AchievementsDTO {
            @JSONField(name = "total")
            private Integer total;
            @JSONField(name = "highlighted")
            private List<HighlightedDTO> highlighted;

            @NoArgsConstructor
            @Data
            public static class HighlightedDTO {
                @JSONField(name = "name")
                private String name;
                @JSONField(name = "path")
                private String path;
            }
        }

        @NoArgsConstructor
        @Data
        public static class ReleaseDateDTO {
            @JSONField(name = "coming_soon")
            private Boolean comingSoon;
            @JSONField(name = "date")
            private String date;
        }

        @NoArgsConstructor
        @Data
        public static class SupportInfoDTO {
            @JSONField(name = "url")
            private String url;
            @JSONField(name = "email")
            private String email;
        }

        @NoArgsConstructor
        @Data
        public static class ContentDescriptorsDTO {
            @JSONField(name = "ids")
            private List<Integer> ids;
            @JSONField(name = "notes")
            private String notes;
        }

        @NoArgsConstructor
        @Data
        public static class PackageGroupsDTO {
            @JSONField(name = "name")
            private String name;
            @JSONField(name = "title")
            private String title;
            @JSONField(name = "description")
            private String description;
            @JSONField(name = "selection_text")
            private String selectionText;
            @JSONField(name = "save_text")
            private String saveText;
            @JSONField(name = "display_type")
            private Integer displayType;
            @JSONField(name = "is_recurring_subscription")
            private String isRecurringSubscription;
            @JSONField(name = "subs")
            private List<SubsDTO> subs;

            @NoArgsConstructor
            @Data
            public static class SubsDTO {
                @JSONField(name = "packageid")
                private Integer packageid;
                @JSONField(name = "percent_savings_text")
                private String percentSavingsText;
                @JSONField(name = "percent_savings")
                private Integer percentSavings;
                @JSONField(name = "option_text")
                private String optionText;
                @JSONField(name = "option_description")
                private String optionDescription;
                @JSONField(name = "can_get_free_license")
                private String canGetFreeLicense;
                @JSONField(name = "is_free_license")
                private Boolean isFreeLicense;
                @JSONField(name = "price_in_cents_with_discount")
                private Integer priceInCentsWithDiscount;
            }
        }

        @NoArgsConstructor
        @Data
        public static class CategoriesDTO {
            @JSONField(name = "id")
            private Integer id;
            @JSONField(name = "description")
            private String description;
        }

        @NoArgsConstructor
        @Data
        public static class GenresDTO {
            @JSONField(name = "id")
            private String id;
            @JSONField(name = "description")
            private String description;
        }

        @NoArgsConstructor
        @Data
        public static class ScreenshotsDTO {
            @JSONField(name = "id")
            private Integer id;
            @JSONField(name = "path_thumbnail")
            private String pathThumbnail;
            @JSONField(name = "path_full")
            private String pathFull;
        }

        @NoArgsConstructor
        @Data
        public static class MoviesDTO {
            @JSONField(name = "id")
            private Integer id;
            @JSONField(name = "name")
            private String name;
            @JSONField(name = "thumbnail")
            private String thumbnail;
            @JSONField(name = "webm")
            private WebmDTO webm;
            @JSONField(name = "mp4")
            private Mp4DTO mp4;
            @JSONField(name = "highlight")
            private Boolean highlight;

            @NoArgsConstructor
            @Data
            public static class WebmDTO {
                @JSONField(name = "480")
                private String $480;
                @JSONField(name = "max")
                private String max;
            }

            @NoArgsConstructor
            @Data
            public static class Mp4DTO {
                @JSONField(name = "480")
                private String $480;
                @JSONField(name = "max")
                private String max;
            }
        }
    }
}