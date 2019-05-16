package com.example.kuyou.dao;

import com.example.kuyou.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserDao {
    //获取用户其他信息
    public Map<String, Object> getOtherinfo(Map<String,Object> group);

    //音乐收藏
    public void collectMusic(Map<String,Object> group);
    public void discollectMusic(Map<String,Object> group);
    //标签收藏
    public void collectLabel(Map<String,Object> group);
    public void discollectLabel(Map<String,Object> group);
    //视频点赞
    public void thumbVideo(Map<String,Object> group);
    public void addthumbVideo(long resource_id);
    public void disthumbVideo(Map<String,Object> group);
    public void delthumbVideo(long resource_id);
    //评论点赞
    public void thumbCommon(Map<String,Object> group);
    public void addthumbCommon(long resource_id);
    public void disthumbCommon(Map<String,Object> group);
    public void delthumbCommon(long resource_id);
    //用户关注
    public void noticeUser(Map<String,Object> group);
    public void addFollowingnum(long u_id);
    public void addFannum(long resource_id);
    public void disnoticeUser(Map<String,Object> group);
    public void delFollowingnum(long u_id);
    public void delFannum(long resource_id);

    //旅行状态
    public int travelState1(Map<String,Object> group);
    public int travelState2(Map<String,Object> group);
    public int travelState3(Map<String,Object> group);
    public int travelState4(Map<String,Object> group);
    public void changeTravelstate(long id);
    public void cancelTravelstate(long id);

    //获取粉丝列表
    public List<User> getFanslist(Map<String,Object> group);
    //获取关注列表
    public List<User> getFollowslist(Map<String,Object> group);

    //判断关注状态
    public int getFanState1(Map<String,Object> group);
    public int getFanState2(Map<String,Object> group);
}
