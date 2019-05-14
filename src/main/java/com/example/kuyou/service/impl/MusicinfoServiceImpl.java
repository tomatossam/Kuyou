package com.example.kuyou.service.impl;

import com.example.kuyou.dao.MusicinfoDao;
import com.example.kuyou.entity.Musicinfo;
import com.example.kuyou.service.MusicinfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MusicinfoServiceImpl implements MusicinfoService {

    @Resource
    MusicinfoDao musicinfoDao;

    public List<Musicinfo> getMusicinfomation(long u_id, String m_kind){
        Map<String,Object> group=new HashMap<String, Object>();
        group.put("u_id",u_id);
        group.put("m_kind",m_kind);
        if(m_kind.equals("COLLECTED"))
            return musicinfoDao.getCollectedMusic(u_id);
        else if(m_kind.equals("CLEAR")||m_kind.equals("ROCK")||m_kind.equals("SOFT")||m_kind.equals("ROMANTIC")||m_kind.equals("HEALING"))
            return musicinfoDao.getTypeMusic(group);
        else
            return null;
    }

    public Map<String, Object> getMusicdetails(long m_id,long u_id) {
        Map<String,Object> group=new HashMap<String, Object>();
        group.put("m_id",m_id);
        group.put("u_id",u_id);
        return musicinfoDao.getMusicdetails(group);
    }

}
