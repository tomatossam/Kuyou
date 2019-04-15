package com.example.kuyou.controller;

import com.example.kuyou.entity.Thumbinfo;
import com.example.kuyou.service.ThumbinfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
public class ThumbinfoController {

    @Resource
    ThumbinfoService thumbinfoService;

    //接口14
    @RequestMapping(value = "message/thumb",method = RequestMethod.GET)
    public List<Thumbinfo> getThumbinfo(@RequestParam long u_id){return thumbinfoService.getThumbinfo(u_id);}

}
