package com.example.kuyou.dao;

import com.example.kuyou.entity.Labelusenum;

import java.util.List;
import java.util.Map;

public interface FileUploadDao {

    public int getVideocount();
    public void insertVideoinfo(Map<String,Object> group);

    public int getLabelnum(String label);
    public void insertLabel(Map<String,Object> group);

    public int getJoinlabelcount(Map<String,Object> group);
    public void insertJoinlabel(Map<String,Object> group);

    public int getViewid1(Map<String,Object> group);
    public int getViewid2(Map<String,Object> group);
    public int getViewid3(Map<String,Object> group);
    public int getViewid4(Map<String,Object> group);

    public List<Labelusenum> searchLabel(String labels);

    public void alterBackcover(Map<String,Object> group);
    public void alterHeadcover(Map<String,Object> group);

    public Map<String,Object> getVideoinfo(Map<String,Object> group);
}
