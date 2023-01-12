package edu.hebeu.steam.pojo.Sys;

import edu.hebeu.steam.pojo.Base.BaseModel;
import lombok.Data;

@Data
public class SysLog extends BaseModel {

    private String userName;

    private String operation;

    private String method;

    private String params;

    private Long time;

    private String ip;
}
