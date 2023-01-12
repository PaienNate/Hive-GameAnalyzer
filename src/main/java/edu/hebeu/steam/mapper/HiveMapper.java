package edu.hebeu.steam.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.hebeu.steam.pojo.hive.HiveGame;
import edu.hebeu.steam.pojo.viewdata.Base2Pojo;
import edu.hebeu.steam.pojo.viewdata.DeveloperTable;
import edu.hebeu.steam.pojo.viewdata.LanguageCompare;
import edu.hebeu.steam.pojo.viewdata.MostOwnerGamePojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
@DS("hive")
public interface HiveMapper extends BaseMapper<HiveGame> {
    @Select("select * from genreAndvalue;")
    public List<Base2Pojo> getGenreAndvalue();

    @Select("select * from bad_genreAndvalue;")
    public List<Base2Pojo> getBadGenreAndvalue();
    //@Select("SELECT * FROM (SELECT *, ROW_NUMBER() OVER(Order by a desc) as rowid FROM owner ) t1 WHERE rowid > 0 and rowid <= 10;")
    //public List<>
    @Select("select `appid`,`name`,`value` from owner order by a desc limit ${num};")
    public List<MostOwnerGamePojo> getMostOwnerGame(@Param("num")String num);

    @Select("select DISTINCT * from developer where dev='${developer}';")
    public List<DeveloperTable> getDeveloperDetail(@Param("developer")String developer);

    @Select("select DISTINCT * from genre where gen='${gen}' order by positive desc limit 20;")
    public List<DeveloperTable> getGenreDetail(@Param("gen")String genre);

    @Select("select * from cloud;")
    public List<Base2Pojo> getWordCount();

    @Select("select * from language;")
    public List<LanguageCompare> getLanguageCompare();

    @Select("SELECT name, value FROM default.positives where appid='${appid}';")
    public List<Base2Pojo> getDropPicForPositive(@Param(value="appid")int appid);

    @Select("select `appid`,`name`,`value` from median order by a desc limit ${num};")
    public List<MostOwnerGamePojo> getMostMedianGame(@Param("num")String num);



}
