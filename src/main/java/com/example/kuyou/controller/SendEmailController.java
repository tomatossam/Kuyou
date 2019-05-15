package com.example.kuyou.controller;

import com.example.kuyou.entity.Email;
import com.example.kuyou.service.SendEmailService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class SendEmailController {

    @Resource
    private SendEmailService sendEmailService;

    //获取邮箱验证码
    @RequestMapping(value = "user/getcode",method = RequestMethod.GET)
    public String getCode(@RequestParam String email){return sendEmailService.sendSimpleMail(email);}

    //注册
    @RequestMapping(value = "user/register",method = RequestMethod.POST,produces= "application/json;charset=UTF-8")
    public String userRegister(@RequestParam String email, @RequestParam String code_num, @RequestParam String password){return sendEmailService.userRegister(email,code_num,password);}

    //登录
    @RequestMapping(value = "user/login",method = RequestMethod.POST,produces= "application/json;charset=UTF-8")
    public String userLogin(@RequestParam String email, @RequestParam String password)
    {return sendEmailService.userLogin(email,password);}

    //修改密码
    @RequestMapping(value = "user/alterpwd",method = RequestMethod.POST,produces= "application/json;charset=UTF-8")
    public String alterPwd(@RequestParam String email, @RequestParam String code_num, @RequestParam String password){return sendEmailService.userAlterpwd(email,code_num,password);}

    //修改个人资料
    @RequestMapping(value = "user/alterinfo",method = RequestMethod.POST,produces= "application/json;charset=UTF-8")
    public String alterinfo(@RequestParam long u_id,@RequestParam String nick,@RequestParam String sex,@RequestParam String signature,@RequestParam int age,@RequestParam String city)
    {return sendEmailService.alterInfo(u_id,nick,sex,signature,age,city);}



}
