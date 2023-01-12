package edu.hebeu.steam.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import edu.hebeu.steam.pojo.Sys.SysMenu;
import edu.hebeu.steam.pojo.viewdata.EvolveFork;

import java.util.List;

public interface MenuService extends IService<SysMenu> {

    EvolveFork getManageChartData();

    List<SysMenu> findByUser(String userName, Wrapper<SysMenu> queryWrapper);

    List<SysMenu> findTree(String userName, int menuType, String name);
}
