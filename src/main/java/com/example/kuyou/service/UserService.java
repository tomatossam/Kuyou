package com.example.kuyou.service;


import com.example.kuyou.entity.User;
import java.util.List;
import java.util.Map;

public interface UserService {

    public Map<String, Object> getOtherinfo(long id);
    public int resourceRequest(String resource_post_kind,long resource_id,long u_id );
    public int postTravelstate(String position,int u_id);

    public List<User> getFanslist(long u_id,long target_id);
    public List<User> getFollowslist(long u_id,long target_id);
}
