package edu.hebeu.steam.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.hebeu.steam.pojo.Gamedata2;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@DS("hive")
@Mapper
public interface GameMapper extends BaseMapper<Gamedata2> {
}
