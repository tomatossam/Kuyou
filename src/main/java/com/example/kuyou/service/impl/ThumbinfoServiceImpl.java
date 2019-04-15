package com.example.kuyou.service.impl;

import com.example.kuyou.dao.ThumbinfoDao;
import com.example.kuyou.entity.Thumbinfo;
import com.example.kuyou.service.ThumbinfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ThumbinfoServiceImpl implements ThumbinfoService {

    @Resource
    ThumbinfoDao thumbinfoDao;

    public List<Thumbinfo> getThumbinfo(long u_id){return thumbinfoDao.getThumbinfo(u_id);}

}
