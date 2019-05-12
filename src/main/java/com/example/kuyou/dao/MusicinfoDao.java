package com.example.kuyou.dao;

import com.example.kuyou.entity.Musicinfo;

import java.util.List;
import java.util.Map;

public interface MusicinfoDao {

    public List<Musicinfo> getCollectedMusic(long u_id);

    public List<Musicinfo> getTypeMusic(Map<String,Object> group);


}
