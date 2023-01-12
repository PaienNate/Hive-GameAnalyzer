package edu.hebeu.steam.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.hebeu.steam.pojo.hive.DevEvaluate;

public interface DevEvaluateService extends IService<DevEvaluate> {


    String getCommentForDeveloper(String dev);
}
