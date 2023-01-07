package edu.hebeu.steam.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.hebeu.steam.pojo.SysLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@DS("mysql")
public interface SysLogMapper extends BaseMapper<SysLog> {
}
