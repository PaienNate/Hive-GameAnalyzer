package edu.hebeu.steam.pojo;

import edu.hebeu.steam.pojo.viewdata.Base2Pojo;
import lombok.Data;

import java.util.List;

@Data
public class Base2PojoExtend {
    List<Base2Pojo> base2PojoList;
    String gamename;
    String description;
    String sd;
}
