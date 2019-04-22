package com.example.kuyou.controller;

/*
 * author dpc
 * */


import com.example.kuyou.impl.NearbyHot;
import com.example.kuyou.object.HotNearby;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("nearby")
public class NearbyController {

    private WebApplicationContext context;

    @Autowired
    public NearbyController(WebApplicationContext context){
        this.context = context;
    }

    @RequestMapping("hot")
    public List<HotNearby> hotNearbies(HttpServletRequest request){
        String location = request.getParameter("location");
        return context.getBean(NearbyHot.class).getHotNearby(location);
    }
}

