package com.example.kuyou.controller;

/*
 * author dpc
 * */

import com.example.kuyou.impl.CommonMessage;
import com.example.kuyou.object.MessageCommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("message")
public class MessageController {

    private WebApplicationContext context;

    @Autowired
    public MessageController(WebApplicationContext context){
        this.context = context;
    }

    @RequestMapping(value = "common", method = RequestMethod.GET)
    public List<MessageCommon> messageCommons(HttpServletRequest request){
        long u_id = Long.parseLong(request.getParameter("u_id"));
        return context.getBean(CommonMessage.class).getMessageCommons(u_id);
    }

}
