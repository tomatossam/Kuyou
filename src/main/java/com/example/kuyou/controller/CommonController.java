package com.example.kuyou.controller;

import com.example.kuyou.entity.Common;
import com.example.kuyou.service.CommonService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
public class CommonController {

    @Resource
    CommonService commonService;

    //接口7
    @RequestMapping(value = "common/look",method = RequestMethod.GET)
    public List<Common> getCommon(@RequestParam long v_id){return commonService.getCommons(v_id);}

    //接口8
    @RequestMapping(value = "common/talk",method = RequestMethod.POST)
    public int postCommon(@RequestParam long u_id,@RequestParam long v_id,@RequestParam String vc_content){return commonService.postCommons(u_id,v_id,vc_content);}


}
