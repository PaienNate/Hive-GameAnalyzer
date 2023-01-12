package edu.hebeu.steam.pojo.Sys;

import com.baomidou.mybatisplus.annotation.TableField;
import edu.hebeu.steam.pojo.Base.BaseModel;
import lombok.Data;

import java.util.List;


@Data
public class SysMenu extends BaseModel {

    private Long parentId;

    private String name;

    private String url;

    private Integer type;

    private String icon;

    private Integer orderNum;

    private Byte delFlag;

    @TableField(exist = false)
    private String parentName;
    @TableField(exist = false)
    private Integer level;
    @TableField(exist = false)
    private List<SysMenu> children;
}
