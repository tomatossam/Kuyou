package com.example.kuyou.service.impl;

import com.example.kuyou.dao.SendEmailDao;
import com.example.kuyou.entity.Email;
import com.example.kuyou.service.SendEmailService;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.jdbc.Null;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class SendEmailServiceImpl implements SendEmailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SendEmailServiceImpl.class);
    @Resource
    private JavaMailSender mailSender;
    @Resource
    private SendEmailDao sendEmailDao;

    public String sendSimpleMail(String email)  {
        LOGGER.info("准备发送简单邮件");
        String checkCode = String.valueOf(new Random().nextInt(899999) + 100000);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("853237267@qq.com");
        message.setTo(email);
        message.setSubject("主题：酷游验证码");
        message.setText(checkCode);
        mailSender.send(message);

        Map<String,Object> group=new HashMap<String, Object>();
        group.put("email",email);
        group.put("checkCode",checkCode);
        int count=sendEmailDao.checkEmail(email);
        if(count==0) sendEmailDao.register(group); //表示邮箱未存在，数据库插入数据
        else sendEmailDao.alterCodenum(group); //表示邮箱已存在，修改验证码
        return checkCode;
    }

    public String userRegister(String email,String code_num,String password) {
        Email newUser = sendEmailDao.checkCode(code_num);
        if (newUser != null) {
            if (email.equals(newUser.getEmail())) {
                if (password.length() < 5 || password.length() > 15)
                    return "2";   //密码超出范围
                else if (sendEmailDao.getStatus(email).equals("1"))
                    return "3";     //邮箱已注册
                else {
                    Map<String,Object> group=new HashMap<String, Object>();
                    group.put("code_num",code_num);
                    group.put("password",password);
                    sendEmailDao.register2(group);
                    return "1"; //注册成功
                }
            }
            else
                return "4";
        }
        else
            return "4";  //验证码错误
    }

    public String userLogin(String email,String pwd){
        int count=sendEmailDao.checkEmail(email);
        Map<String,Object> group=new HashMap<String, Object>();
        group.put("email",email);
        group.put("pwd",pwd);
        Email newUser = sendEmailDao.loginUser(group);
        if(newUser==null) {
            if (count == 0)
                return "3";//未注册
            else return "2";//账号或密码错误
        }
        else{
            if (sendEmailDao.getStatus(email).equals("0"))
                    return "3";//未注册
            else return "1";//登录成功
            }
    }

    public String userAlterpwd(String email,String code_num,String password) {
        Email newUser = sendEmailDao.checkCode(code_num);
        if (newUser != null) {
            if (email.equals(newUser.getEmail())) {
                if (password.length() < 5 || password.length() > 15)
                    return "2";   //密码超出范围
                else if (sendEmailDao.getStatus(email).equals("0"))
                    return "3";     //邮箱未注册
                else {
                    Map<String,Object> group=new HashMap<String, Object>();
                    group.put("code_num",code_num);
                    group.put("password",password);
                    sendEmailDao.register2(group);
                    return "1"; //密码修改成功
                }
            }
            else
                return "3";
        }
        else
            return "4";  //验证码错误

    }

    public String alterInfo(int u_id, String nick,String sex, String signature, int age, String city)
    {

        Map<String,Object> group=new HashMap<String, Object>();
        group.put("u_id",u_id);
        group.put("nick",nick);
        group.put("sex",sex);
        group.put("signature",signature);
        group.put("age",age);
        group.put("city",city);
        sendEmailDao.alterInfo(group);
        return "1";
    }


}
