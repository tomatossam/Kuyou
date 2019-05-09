package com.example.kuyou.service;

import com.example.kuyou.entity.Musicinfo;

import java.util.List;
import java.util.Map;

public interface MusicinfoService {

    public List<Musicinfo> getMusicinfomation(long u_id, String m_kind);

}
