package com.example.kuyou.service;

import com.example.kuyou.entity.Common;

import java.util.List;

public interface CommonService {
    public List<Common> getCommons(long v_id);
    public int postCommons(long u_id,long v_id,String vc_content);
}
