package edu.hebeu.steam.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.hebeu.steam.pojo.Base.Data;
import edu.hebeu.steam.pojo.alipay.SysPay;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@DS("mysql")
@Mapper
public interface AliMapper extends BaseMapper<SysPay> {
}
