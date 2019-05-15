package com.example.kuyou.service;

import com.example.kuyou.entity.Labelusenum;

import java.util.List;

public interface FileUploadService {

    public String uploadVideo(long v_creator,String position,int m_id,String label,String v_description,String v_date,String v_content,String v_cover);

    public int getVideocount();

    public List<Labelusenum> searchLabel(String labels);

    public void alterBackcover(long u_id, String bg_img);

    public void alterHeadcover(long u_id, String head);
}
