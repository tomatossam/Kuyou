package com.example.kuyou.service;


import com.example.kuyou.entity.Activitysp;

import java.util.List;
import java.util.Map;

public interface ActivityinfoService {

    public Map<String, Object> getActivityinfos(long a_id);

    public Map<String, Object> getActivityinfos2(long a_id);

    public List<String> getActivityVideo(long a_id);

    public int getActivityNum();

    public void insertActivity(long l_id,String a_user_indro,String a_cover);

    public void deletePreActivity(long l_id);

    public List<Activitysp> getActivitysplist();

}
