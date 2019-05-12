package com.example.kuyou.service;

import com.example.kuyou.entity.Email;

import java.util.Map;

public interface SendEmailService {

    public String sendSimpleMail(String email);

    public String userRegister(String email,String code_num,String password);

    public String userLogin(String email,String pwd);

    public String userAlterpwd(String email,String code_num,String pwd);

    public String alterInfo(int u_id, String nick,String sex, String signature, int age);


}
