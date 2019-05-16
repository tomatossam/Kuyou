package com.example.kuyou.controller;

import com.example.kuyou.entity.User;
import com.example.kuyou.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class UserController {
    @Resource
    UserService userService;

    //接口4
    @RequestMapping(value = "/user/home",method = RequestMethod.GET,produces={"application/json;charset=utf-8"})
    public Map<String, Object> getOtherinf(@RequestParam long u_id,@RequestParam long target_id) { return userService.getOtherinfo(u_id,target_id);}

    //接口5
    @RequestMapping(value = "/user/resource",method = RequestMethod.POST)
    public int resourceRequest(@RequestParam(value = "resource_post_kind", required = false) String resource_post_kind,
                                @RequestParam(value = "resource_id", required = false) Integer resource_id,
                                @RequestParam(value = "u_id", required = false) Integer u_id )
    {return userService.resourceRequest(resource_post_kind,resource_id,u_id);}

    //接口6
    @RequestMapping(value = "/user/travel_stat",method = RequestMethod.POST)
    public int postTravelstate(@RequestParam String position,@RequestParam long u_id){return userService.postTravelstate(position,u_id);}

    //获取粉丝列表
    @RequestMapping(value = "/user/fanslist",method = RequestMethod.GET)
    public List<User> getFanslist(@RequestParam long u_id,@RequestParam long target_id){return userService.getFanslist(u_id,target_id);}

    //获取关注列表
    @RequestMapping(value = "/user/followslist",method = RequestMethod.GET)
    public List<User> getFollowslist(@RequestParam long u_id,@RequestParam long target_id){return userService.getFollowslist(u_id,target_id);}

}
