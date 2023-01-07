package edu.hebeu.steam.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SysUser extends BaseModel {

    private String name;

    private String password;

    private String salt;

    private String email;

    private Byte status;

    private Byte delFlag;



}
