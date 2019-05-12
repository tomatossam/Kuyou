package com.example.kuyou.dao;

import com.example.kuyou.entity.Email;

import java.util.Map;

public interface SendEmailDao {

    public void register(Map<String,Object> group);

    public int checkEmail(String email);

    public void alterCodenum(Map<String,Object> group);

    public void register2(Map<String,Object> group);

    Email checkCode(String email);

    Email loginUser(Map<String,Object> group);

    public void alterInfo(Map<String,Object> group);

    public String getStatus(String email);


}
