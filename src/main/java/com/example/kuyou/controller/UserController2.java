package com.example.kuyou.controller;

/*
 * author dpc
 * */

import com.example.kuyou.impl.UserCreator;
import com.example.kuyou.object.Creator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("user")
public class UserController2 {

    private WebApplicationContext context;

    @Autowired
    public UserController2(WebApplicationContext context){
        this.context = context;
    }

    @RequestMapping(value = "creator", method = RequestMethod.GET)
    public Creator getCreator(HttpServletRequest request){
        long v_creator = Long.parseLong(request.getParameter("v_creator"));
        long u_id = Long.parseLong(request.getParameter("u_id"));

        return context.getBean(UserCreator.class).getCreator(u_id, v_creator);
    }
}
