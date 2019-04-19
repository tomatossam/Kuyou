package com.example.kuyou.controller;

/*
* author dpc
* */


import com.example.kuyou.impl.ActivityHot;
import com.example.kuyou.object.HotActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@RestController
@RequestMapping("activity")
public class ActivityController {

    private WebApplicationContext context;

    @Autowired
    public ActivityController(WebApplicationContext context){
        this.context = context;
    }

    @RequestMapping("hot")
    public List<HotActivity> hotActivities(){
        ActivityHot hot = context.getBean(ActivityHot.class);
        return hot.getHotActivities();
    }
}
