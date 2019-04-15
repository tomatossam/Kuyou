package com.example.kuyou.controller;

import com.example.kuyou.entity.Activityinfo;
import com.example.kuyou.service.ActivityinfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin@RestController
public class ActivityinfoController {

    @Resource
    ActivityinfoService activityinfoService;

    //接口10
    @RequestMapping(value = "activity/information",method = RequestMethod.GET)
    public Activityinfo getActivityinfos(@RequestParam long l_id)
    {return activityinfoService.getActivityinfos(l_id);}

}
