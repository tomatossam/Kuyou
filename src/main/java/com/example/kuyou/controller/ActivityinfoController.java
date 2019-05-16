package com.example.kuyou.controller;

import com.example.kuyou.entity.Activitysp;
import com.example.kuyou.service.ActivityinfoService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@CrossOrigin@RestController
public class ActivityinfoController {

    @Resource
    ActivityinfoService activityinfoService;

    private String a_cover;

    //接口10  获取普通活动
    @RequestMapping(value = "activity/getnormal",method = RequestMethod.GET)
    public Map<String, Object> getActivityinfos(@RequestParam long a_id)
    {return activityinfoService.getActivityinfos(a_id);}

    //获取轮播图活动
    @RequestMapping(value = "activity/getspecial",method = RequestMethod.GET)
    public Map<String, Object> getActivityinfos2(@RequestParam long a_id)
    {return activityinfoService.getActivityinfos2(a_id);}

    //获取活动视频
    @RequestMapping(value = "activity/getvideo",method = RequestMethod.GET)
    public List<String> getActivityVideo(@RequestParam long a_id)
    {return activityinfoService.getActivityVideo(a_id);}

    //活动注册
    @RequestMapping(value = "activity/register",method = RequestMethod.POST)
    public String activityRegister(@RequestParam long l_id,@RequestParam String a_user_indro,@RequestParam("fileName") MultipartFile file) {
        if (file.isEmpty()) { return "上传文件不可为空"; }
        //获取文件名
        int a_id=activityinfoService.getActivityNum()+1;
        String fileName = String.valueOf(a_id)+".png";

        //绝对路径
        String path = "F:/kuYou/coverActivity/" +fileName;

        //创建文件路径
        File dest = new File(path);

        //判断文件父目录是否存在
        if (!dest.getParentFile().exists()) { dest.getParentFile().mkdir(); }

        try {
            //上传文件
            file.transferTo(dest); //保存文件
            System.out.print("保存活动封面文件路径"+path+"\n");
            a_cover=fileName;//本地运行项目
        } catch (IOException e) {
            return "0";
        }

        activityinfoService.insertActivity(l_id,a_user_indro,a_cover);

        activityinfoService.deletePreActivity(l_id);

        return "1";
    }

    //获取特殊活动列表
    @RequestMapping(value = "activity/banner",method = RequestMethod.GET)
    public List<Activitysp> getActivitysplist(){return activityinfoService.getActivitysplist();}
}
