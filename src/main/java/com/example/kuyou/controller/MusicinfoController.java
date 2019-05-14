package com.example.kuyou.controller;

import com.example.kuyou.entity.Musicinfo;
import com.example.kuyou.service.MusicinfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class MusicinfoController {

    @Resource
    MusicinfoService musicinfoService;

    //接口15
    @RequestMapping(value = "music/information",method = RequestMethod.GET)
    public List<Musicinfo> getMusicinfomations(@RequestParam long u_id, @RequestParam String m_kind){return musicinfoService.getMusicinfomation(u_id,m_kind);}

    //获取音乐详细信息
    @RequestMapping(value = "music/single",method = RequestMethod.GET)
    public Map<String,Object> getMusicdetails(@RequestParam long m_id, @RequestParam long u_id){return musicinfoService.getMusicdetails(m_id,u_id);}
}
