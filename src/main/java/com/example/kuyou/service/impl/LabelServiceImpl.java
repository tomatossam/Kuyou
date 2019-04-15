package com.example.kuyou.service.impl;

import com.example.kuyou.dao.LabelDao;
import com.example.kuyou.entity.Label;
import com.example.kuyou.service.LabelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LabelServiceImpl implements LabelService {

    @Resource
    LabelDao labelDao;

    public Label getLabeltypes(String content){return labelDao.getLabeltype(content);}

}
