package edu.hebeu.steam.pojo.Base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;
@Data
public class BaseModel {
    // 数据库自增id
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    private String createBy;

    private Date createTime;

    private String lastUpdateBy;

    private Date lastUpdateTime;
}