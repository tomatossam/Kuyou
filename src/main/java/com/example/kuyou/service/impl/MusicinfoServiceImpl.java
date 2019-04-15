package com.example.kuyou.service.impl;

import com.example.kuyou.dao.MusicinfoDao;
import com.example.kuyou.entity.Musicinfo;
import com.example.kuyou.service.MusicinfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class MusicinfoServiceImpl implements MusicinfoService {

    @Resource
    MusicinfoDao musicinfoDao;

    public Musicinfo getMusicinfomation(long m_id, long u_id){
        Map<String,Object> group=new HashMap<String, Object>();
        group.put("m_id",m_id);
        group.put("u_id",u_id);
        return musicinfoDao.getMusicinfo(group);
    }

}
