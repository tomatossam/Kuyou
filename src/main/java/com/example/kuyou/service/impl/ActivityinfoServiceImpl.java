package com.example.kuyou.service.impl;

import com.example.kuyou.dao.ActivityinfoDao;
import com.example.kuyou.entity.Activityinfo;
import com.example.kuyou.service.ActivityinfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ActivityinfoServiceImpl implements ActivityinfoService {

    @Resource
    ActivityinfoDao activityinfoDao;

    public Activityinfo getActivityinfos(long l_id){
        return activityinfoDao.getActitityfinfo(l_id);
    }

}
