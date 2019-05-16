package com.example.kuyou.dao;


import com.example.kuyou.entity.Activitysp;

import java.util.List;
import java.util.Map;

public interface ActivityinfoDao {

    public Map<String, Object> getActitityfinfo(long a_id);

    public Map<String, Object> getInfos(long a_id);

    public List<String> getActivityVideos(long a_id);

    public int getActivityNum();

    public void insertActivity1(Map<String, Object> group);

    public void insertActivity2(Map<String, Object> group);

    public void deletePreActivity(long l_id);

    public List<Activitysp> getActivitysplist();

}
