package edu.hebeu.steam.controller;

import edu.hebeu.steam.annotation.Log;
import edu.hebeu.steam.common.result.CommonResult;
import edu.hebeu.steam.pojo.Sys.SysMenu;
import edu.hebeu.steam.pojo.viewdata.EvolveFork;
import edu.hebeu.steam.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @Log("新增/修改菜单")
    @PostMapping(value="/save")
    public CommonResult save(@RequestBody SysMenu record) {
        if (record.getParentId() == null) {
            record.setParentId(0L);
        }
        menuService.saveOrUpdate(record);
        return CommonResult.success();
    }

    @Log("删除菜单/按钮")
    @PostMapping(value="/delete")
    public CommonResult delete(@RequestBody List<SysMenu> records) {
        for (SysMenu record : records) {
            menuService.removeById(record.getId());
        }
        return CommonResult.success(records.size());
    }

    @GetMapping("/findNavTree")
    public CommonResult findNavTree(@RequestParam String username) {
        List<SysMenu> menuList = menuService.findTree(username, 1, null);
        return CommonResult.success(menuList);
    }

    @GetMapping("/findMenuTree")
    public CommonResult findMenuTree(@RequestParam String name) {
        List<SysMenu> menuList = menuService.findTree(null, 0, name);
        return CommonResult.success(menuList);
    }

    @Log("删除菜单/按钮")
    @GetMapping(value="/getMenu")
    public EvolveFork getMenuTable() {
        return menuService.getManageChartData();
    }



}
