package edu.hebeu.steam.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import edu.hebeu.steam.pojo.SysMenu;

import java.util.List;
import java.util.Set;

public interface MenuService extends IService<SysMenu> {

    List<SysMenu> findByUser(String userName, Wrapper<SysMenu> queryWrapper);

    List<SysMenu> findTree(String userName, int menuType, String name);
}
