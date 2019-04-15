package com.example.kuyou.controller;

import com.example.kuyou.entity.Musicinfo;
import com.example.kuyou.service.MusicinfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin
@RestController
public class MusicinfoController {

    @Resource
    MusicinfoService musicinfoService;

    //接口15
    @RequestMapping(value = "music/information",method = RequestMethod.GET)
    public Musicinfo getMusicinfomations(@RequestParam int m_id,@RequestParam int u_id){return musicinfoService.getMusicinfomation(m_id,u_id);}
}
