package com.example.kuyou.controller;

/*
* 修改：重新实现这个dpc
* */

import com.example.kuyou.entity.Label;
import com.example.kuyou.impl.LabelInfoGet;
import com.example.kuyou.object.LabelInfor;
import com.example.kuyou.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@CrossOrigin
@RestController
public class LabelController {

    private WebApplicationContext context;

    @Autowired
    public LabelController(WebApplicationContext context){
        this.context = context;
    }

    //接口9
    @RequestMapping(value = "label/kind",method = RequestMethod.GET)
    public LabelInfor getLabelInfo(HttpServletRequest request){
        String content = request.getParameter("content");

        return context.getBean(LabelInfoGet.class).getLabelInfo(content);
    }

}
