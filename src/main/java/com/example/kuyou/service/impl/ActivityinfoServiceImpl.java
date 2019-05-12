package com.example.kuyou.service.impl;

import com.example.kuyou.dao.ActivityinfoDao;
import com.example.kuyou.service.ActivityinfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ActivityinfoServiceImpl implements ActivityinfoService {

    @Resource
    ActivityinfoDao activityinfoDao;

    public Map<String, Object> getActivityinfos(long a_id){ return activityinfoDao.getActitityfinfo(a_id); }

    public Map<String, Object> getActivityinfos2(long a_id){ return activityinfoDao.getInfos(a_id);}//用户未填描述，默认使用官方描述

    public List<String> getActivityVideo(long a_id){ return  activityinfoDao.getActivityVideos(a_id); }

    public int getActivityNum(){return activityinfoDao.getActivityNum();}

    public void insertActivity(long l_id,String a_user_indro,String a_cover){
        Map<String,Object> group=new HashMap<String, Object>();
        group.put("l_id",l_id);group.put("a_user_indro",a_user_indro);group.put("a_cover",a_cover);
        if(a_user_indro.length()<=0) { activityinfoDao.insertActivity1(group); }
        else activityinfoDao.insertActivity2(group);
    }

    public void deletePreActivity(long l_id){activityinfoDao.deletePreActivity(l_id);}


}
