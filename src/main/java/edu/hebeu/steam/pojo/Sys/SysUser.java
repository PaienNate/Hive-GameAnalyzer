package edu.hebeu.steam.pojo.Sys;

import edu.hebeu.steam.pojo.Base.BaseModel;
import lombok.Data;

@Data
public class SysUser extends BaseModel {

    private String name;

    private String password;

    private String salt;

    private String email;

    private Byte status;

    private Byte delFlag;



}
