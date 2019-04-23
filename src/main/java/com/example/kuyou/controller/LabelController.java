package com.example.kuyou.controller;

/*
* 修改：重新实现这个dpc
* */

import com.example.kuyou.entity.Label;
import com.example.kuyou.service.LabelService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin
@RestController
public class LabelController {

    @Resource
    LabelService labelService;


    //接口9
    @RequestMapping(value = "label/kind",method = RequestMethod.GET)
    public Label getLabeltypes(@RequestParam  String content){return labelService.getLabeltypes(content);}

}
