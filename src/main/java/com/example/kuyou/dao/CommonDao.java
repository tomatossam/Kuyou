package com.example.kuyou.dao;

import com.example.kuyou.entity.Common;

import java.util.List;
import java.util.Map;

public interface CommonDao {

    public List<Common> getCommons(long v_id);
    public void postCommons(Map<String,Object> group);

}
