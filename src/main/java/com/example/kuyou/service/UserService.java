package com.example.kuyou.service;


import java.util.Map;

public interface UserService {

    public Map<String, Object> getOtherinfo(long id);
    public int resourceRequest(String resource_post_kind,long resource_id,long u_id );
    public int postTravelstate(String position,int u_id);

}
