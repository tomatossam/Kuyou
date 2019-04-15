package com.example.kuyou.service.impl;

import com.example.kuyou.dao.CommonDao;
import com.example.kuyou.entity.Common;
import com.example.kuyou.service.CommonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class CommonServiceImpl implements CommonService {

    @Resource
    CommonDao commonDao;

    public List<Common> getCommons(long v_id) { return commonDao.getCommons(v_id); }

    public int postCommons(long u_id,long v_id,String vc_content) {
        Map<String,Object> group=new HashMap<String, Object>();
        String timeA = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String timeB = new SimpleDateFormat("HH:mm").format(new Date());
        group.put("u_id",u_id);
        group.put("v_id",v_id);
        group.put("vc_content",vc_content);
        group.put("timeA",timeA);
        group.put("timeB",timeB);
        if(vc_content.length()>3&&vc_content.length()<50) {
            commonDao.postCommons(group);
            return 1;
        }
        else
            return 0;
    }

}
