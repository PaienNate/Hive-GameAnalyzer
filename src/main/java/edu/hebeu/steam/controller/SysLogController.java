package edu.hebeu.steam.controller;

import edu.hebeu.steam.common.page.PageRequest;
import edu.hebeu.steam.common.result.CommonResult;
import edu.hebeu.steam.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("log")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;



    @PostMapping(value="/findPage")
    public CommonResult findPage(@RequestBody PageRequest pageRequest) {
        return CommonResult.success(sysLogService.findPage(pageRequest));
    }
}
