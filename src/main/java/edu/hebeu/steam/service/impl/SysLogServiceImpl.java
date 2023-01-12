package edu.hebeu.steam.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.hebeu.steam.common.page.ColumnFilter;
import edu.hebeu.steam.common.page.PageRequest;
import edu.hebeu.steam.common.page.PageResult;
import edu.hebeu.steam.mapper.SysLogMapper;
import edu.hebeu.steam.pojo.Sys.SysLog;
import edu.hebeu.steam.service.SysLogService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements SysLogService {
    @Override
    public PageResult findPage(PageRequest pageRequest) {
        ColumnFilter columnFilter = pageRequest.getColumnFilters().get("userName");
        LambdaQueryWrapper<SysLog> wrapper = new LambdaQueryWrapper<>();
        if (columnFilter != null && !StringUtils.isEmpty(columnFilter.getValue())) {
            wrapper.eq(SysLog::getUserName, columnFilter.getValue());
        }
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        Page<SysLog> page = new Page<>(pageNum, pageSize);
        IPage<SysLog> result = baseMapper.selectPage(page, wrapper);
        PageResult pageResult = new PageResult(result);
        return pageResult;
    }
}
