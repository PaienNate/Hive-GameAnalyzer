package edu.hebeu.steam.viewdata;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//和HotChartsVO配合使用
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MostOwnerGamePojo {
    int appid;
    String name;
    int value;
}
