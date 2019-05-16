package com.example.kuyou.service.impl;

import com.example.kuyou.dao.UserDao;
import com.example.kuyou.entity.User;
import com.example.kuyou.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserDao userDao;

    public Map<String, Object> getOtherinfo(long u_id,long target_id){
        Map<String,Object> group=new HashMap<String,Object>();
        group.put("u_id",u_id);group.put("target_id",target_id);
        String notice_kind="0";
        if(userDao.getFanState1(group)==1 && userDao.getFanState2(group)==0)  notice_kind="NOTICE_YES";
        if(userDao.getFanState1(group)==0) notice_kind="NOTICE_NO";
        if(userDao.getFanState1(group)==1 && userDao.getFanState2(group)==1)  notice_kind="NOTICE_TWO";
        Map<String,Object> group2=new HashMap<String,Object>();
        group2.put("target_id",target_id);group2.put("notice_kind",notice_kind);
        return userDao.getOtherinfo(group2);}

    public int resourceRequest(String resource_post_kind,long resource_id,long u_id ) {
        Map<String,Object> group=new HashMap<String, Object>();
        group.put("resource_id",resource_id);
        group.put("u_id",u_id);

        String timeA = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String timeB = new SimpleDateFormat("HH:mm").format(new Date());
        Map<String,Object> groupdate=new HashMap<String, Object>();
        groupdate.put("resource_id",resource_id);
        groupdate.put("u_id",u_id);
        groupdate.put("timeA",timeA);
        groupdate.put("timeB",timeB);

        if(resource_post_kind.equals("COLLECT_MUSIC")) {
            userDao.collectMusic(group);
            System.out.println("收藏背景音乐");
            return 1;
        }
        else if(resource_post_kind.equals("DIS_COLLECT_MUSIC")){
            userDao.discollectMusic(group);
            System.out.println("取消收藏背景音乐");
            return 1;
        }
        else if(resource_post_kind.equals("COLLECT_LABEL")){
            userDao.collectLabel(group);
            System.out.println("收藏标签");
            return 1;
        }
        else if(resource_post_kind.equals("DIS_COLLECT_LABEL")){
            userDao.discollectLabel(group);
            System.out.println("取消收藏标签");
            return 1;
        }
        else if(resource_post_kind.equals("THUMB_VIDEO")){
            userDao.thumbVideo(groupdate);
            userDao.addthumbVideo(resource_id);
            System.out.println("短视频点赞");
            return 1;
        }
        else if(resource_post_kind.equals("DIS_THUMB_VIDEO")){
            userDao.disthumbVideo(groupdate);
            userDao.delthumbVideo(resource_id);
            System.out.println("取消短视频点赞");
            return 1;
        }
        else if(resource_post_kind.equals("THUMB_COMMON")){
            userDao.thumbCommon(groupdate);
            userDao.addthumbCommon(resource_id);
            System.out.println("评论点赞");
            return 1;
        }
        else if(resource_post_kind.equals("DIS_THUMB_COMMON")){
            userDao.disthumbCommon(groupdate);
            userDao.delthumbCommon(resource_id);
            System.out.println("取消评论点赞");
            return 1;
        }
        else if(resource_post_kind.equals("NOTICE_USER")){
            userDao.noticeUser(groupdate);
            userDao.addFollowingnum(u_id);
            userDao.addFannum(resource_id);
            System.out.println("请求关注");
            return 1;
        }
        else if(resource_post_kind.equals("DIS_NOTICE_USER")){
            userDao.disnoticeUser(groupdate);
            userDao.delFollowingnum(u_id);
            userDao.delFannum(resource_id);
            System.out.println("取消关注");
            return 1;
        }
        else{
            System.out.println("错误指令");
            return 0;
        }

    }

    public int postTravelstate(String position,long u_id) {
        String str[]=position.split("·");
        Map<String,Object> group=new HashMap<String, Object>();
        if(str.length==2) {
            group.put("place1",str[0]);group.put("place2",str[1]);
            if(userDao.travelState1(group)!=0) { System.out.println("在旅行中");userDao.changeTravelstate(u_id); }
            else userDao.cancelTravelstate(u_id);
        }
        else if(str.length==3){
            group.put("place1",str[0]);group.put("place2",str[1]);group.put("place3",str[2]);
            if(userDao.travelState2(group)!=0) { System.out.println("在旅行中");userDao.changeTravelstate(u_id); }
            else userDao.cancelTravelstate(u_id);
        }
        else if(str.length==4){
            group.put("place1",str[0]);group.put("place2",str[1]);group.put("place3",str[2]);group.put("place4",str[3]);
            if(userDao.travelState3(group)!=0) { System.out.println("在旅行中");userDao.changeTravelstate(u_id); }
            else userDao.cancelTravelstate(u_id);
        }
        else if(str.length==5){
            group.put("place1",str[0]);group.put("place2",str[1]);group.put("place3",str[2]);group.put("place4",str[3]);group.put("place5",str[4]);
            if(userDao.travelState4(group)!=0) { System.out.println("在旅行中");userDao.changeTravelstate(u_id); }
            else userDao.cancelTravelstate(u_id);
        }
        else return 0;

        for(int i=0;i<str.length;i++)
            System.out.print(str[i]+" ");

        return 1;
    }

    public List<User> getFanslist(long u_id,long target_id){
        Map<String,Object> group=new HashMap<String,Object>();
        group.put("u_id",u_id);group.put("target_id",target_id);
        return userDao.getFanslist(group); }

    public List<User> getFollowslist(long u_id,long target_id){
        Map<String,Object> group=new HashMap<String,Object>();
        group.put("u_id",u_id);group.put("target_id",target_id);
        return userDao.getFollowslist(group);}

}
