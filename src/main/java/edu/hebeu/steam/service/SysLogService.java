package edu.hebeu.steam.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.hebeu.steam.common.page.PageRequest;
import edu.hebeu.steam.common.page.PageResult;
import edu.hebeu.steam.pojo.Sys.SysLog;

public interface SysLogService extends IService<SysLog> {

    PageResult findPage(PageRequest pageRequest);
}
