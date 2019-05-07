package com.example.kuyou.service;

import com.example.kuyou.entity.Email;

public interface SendEmailService {

    public String sendSimpleMail(String email);

    public String userRegister(Email user);

    public String userLogin(String email,String pwd);

    public String alterInfo(int u_id, String nick,String sex, String signature, int age);

}
