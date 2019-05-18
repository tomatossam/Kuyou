package com.example.kuyou.service;

import com.example.kuyou.entity.Email;

import java.util.Map;

public interface SendEmailService {

    public Map<String,Object> sendSimpleMail(String email);

    public Map<String, Object> userRegister(String email,String code_num,String password);

    public Map<String,Object> userLogin(String email,String pwd);

    public String userAlterpwd(String email,String code_num,String pwd);

    public String alterInfo(long u_id, String nick,String sex, String signature, int age, String city);


}
