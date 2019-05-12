package com.example.kuyou.service.impl;


import com.example.kuyou.dao.FileUploadDao;
import com.example.kuyou.dao.UserDao;
import com.example.kuyou.entity.Labelusenum;
import com.example.kuyou.service.FileUploadService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class FileUploadServiceImpl implements FileUploadService {

    @Resource
    FileUploadDao fileUploadDao;
    @Resource
    UserDao userDao;

    //用于更新label表，video表，join-label表
    public String uploadVideo(int v_creator,String position,int m_id,String label,String v_description,String v_date,String v_content,String v_cover){

        //旅行地址解析
        String str[]=position.split("·");
        Map<String,Object> group=new HashMap<String, Object>();
        int view_id=0;
        if(str.length==2) {
            group.put("place1",str[0]);group.put("place2",str[1]);
            if(userDao.travelState1(group)!=0) { view_id=fileUploadDao.getViewid1(group);} //获取景点ID
            else return "0";//判断不在景点中
        }
        if(str.length==3){
            group.put("place1",str[0]);group.put("place2",str[1]);group.put("place3",str[2]);
            if(userDao.travelState2(group)!=0) { view_id=fileUploadDao.getViewid2(group); }
            else return "0";
        }
        if(str.length==4){
            group.put("place1",str[0]);group.put("place2",str[1]);group.put("place3",str[2]);group.put("place4",str[3]);
            if(userDao.travelState3(group)!=0) { view_id=fileUploadDao.getViewid3(group); }
            else return "0";
        }
        if(str.length==5){
            group.put("place1",str[0]);group.put("place2",str[1]);group.put("place3",str[2]);group.put("place4",str[3]);group.put("place5",str[4]);
            if(userDao.travelState4(group)!=0) { view_id=fileUploadDao.getViewid4(group); }
            else return "0";
        }

        //标签解析，更新label表
        String STR[]=label.split("#");
        int len=STR.length;  int [] labelnum=new int[len];
        labelnum[0]=0;
        for(int i=1;i<len;i++) {
            labelnum[i]=fileUploadDao.getLabelnum(STR[i]); //判断是否为新标签
            Map<String,Object> group1=new HashMap<String, Object>();
            if(labelnum[i]==0) {group1.put("l_content",STR[i]);group1.put("u_id",v_creator);group1.put("view_id",view_id);
            fileUploadDao.insertLabel(group1);}//lable表中插入新标签
        }

        //更新video表
        Map<String,Object> group2=new HashMap<String, Object>();
        group2.put("v_creator",v_creator);group2.put("v_content",v_content);group2.put("v_date",v_date);group2.put("m_id",m_id);group2.put("v_description",v_description);
        group2.put("v_cover",v_cover);group2.put("view_id",view_id);
        fileUploadDao.insertVideoinfo(group2);

        //更新Join_label表
        int [] joinlable=new int[len];
        for(int i=1;i<len;i++) {
            Map<String, Object> group3 = new HashMap<String, Object>();
            group3.put("l_content", STR[i]);group3.put("v_content",v_content);
            joinlable[i]=fileUploadDao.getJoinlabelcount(group3);
            if(joinlable[i]==0){fileUploadDao.insertJoinlabel(group3);}
        }

       return "1";

    }

    public int getVideocount(){return fileUploadDao.getVideocount();}

    public List<Labelusenum> searchLabel(String labels){return fileUploadDao.searchLabel(labels);}

    public void alterBackcover(int u_id, String bg_img){
        Map<String,Object> group=new HashMap<String, Object>();
        group.put("u_id",u_id);group.put("bg_img",bg_img);
        fileUploadDao.alterBackcover(group);}

    public void alterHeadcover(int u_id, String head){
        Map<String,Object> group=new HashMap<String, Object>();
        group.put("u_id",u_id);group.put("bg_img",head);
        fileUploadDao.alterBackcover(group);}

}
