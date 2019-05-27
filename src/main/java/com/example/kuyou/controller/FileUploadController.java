package com.example.kuyou.controller;

import com.example.kuyou.entity.Labelusenum;
import com.example.kuyou.service.FileUploadService;
import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class FileUploadController {

    @Resource
    FileUploadService fileUploadService;

    private String v_content;
    private String v_cover;
    private String imgkind;


    public static void fetchFrame(String videofile, String framefile)
            throws Exception {
        long start = System.currentTimeMillis();
        File targetFile = new File(framefile);
        FFmpegFrameGrabber ff = new FFmpegFrameGrabber(videofile);
        ff.start();
        int lenght = ff.getLengthInFrames();
        int i = 0;
        Frame f = null;
        while (i < lenght) {
            // 过滤前5帧，避免出现全黑的图片，依自己情况而定
            f = ff.grabFrame();
            if ((i > 5) && (f.image != null)) {
                break;
            }
            i++;
        }
        opencv_core.IplImage img = f.image;
        int owidth = img.width();
        int oheight = img.height();
        // 对截取的帧进行等比例缩放
        int width = 800;
        int height = (int) (((double) width / owidth) * oheight);
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        bi.getGraphics().drawImage(f.image.getBufferedImage().getScaledInstance(width, height, Image.SCALE_SMOOTH),
                0, 0, null);
        ImageIO.write(bi, "jpg", targetFile);
        //ff.flush();
        ff.stop();
        System.out.println(System.currentTimeMillis() - start);
    }

    //短视频上传
    @RequestMapping(value = "camera/upload",method = RequestMethod.POST)
    public Map<String, Object> uploadVideo(@RequestParam long v_creator, @RequestParam String position, @RequestParam  int m_id,
                                           @RequestParam  String label, @RequestParam String v_description, @RequestParam("fileName") MultipartFile file){

        if (file.isEmpty()) { return null; }

        //获取文件名
        String fileName = String.valueOf(fileUploadService.getVideocount()+1)+".mp4";
        String fileName2 = String.valueOf(fileUploadService.getVideocount()+1)+".png";

        //绝对路径
        String path = "F:/kuYou/video/" +fileName;
        String path2= "F:/kuYou/coverVideo/"+fileName2;

        //创建文件路径
        File dest = new File(path);

        //判断文件父目录是否存在
        if (!dest.getParentFile().exists()) { dest.getParentFile().mkdir(); }

        try {
            //上传文件
            file.transferTo(dest); //保存文件
            System.out.print("保存短视频文件路径"+path+"\n");
            v_content=fileName;//本地运行项目
        } catch (IOException e) {
            return null;
        }

        try {
            FileUploadController.fetchFrame(path,path2);
            v_cover=fileName2;
        } catch (Exception e) {
            e.printStackTrace();
        }

        String v_date= new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        return fileUploadService.uploadVideo(v_creator,position,m_id,label,v_description,v_date,v_content,v_cover);
    }

    //标签关键字检索
    @RequestMapping(value = "label/search",method = RequestMethod.GET)
    public List<Labelusenum> searchLabel(@RequestParam(value = "labels") String l_content){return fileUploadService.searchLabel(l_content);}

    //图片上传
    @RequestMapping(value = "cover/upload",method = RequestMethod.POST)
    public String uploadCover(@RequestParam long u_id,@RequestParam String cover_kind,@RequestParam("fileName") MultipartFile file) {
        if (file.isEmpty()) { return "上传文件不可为空"; }
        //获取文件名
        String fileName = String.valueOf(u_id)+".png";

        //绝对路径
        String path;
        if(cover_kind.equals("background_cover")) {
            path = "F:/kuYou/background/" + fileName;
        }
        else if(cover_kind.equals("head_cover")) {
            path = "F:/kuYou/head/" + fileName;
        }
        else return "0";

        //创建文件路径
        File dest = new File(path);

        //判断文件父目录是否存在
        if (!dest.getParentFile().exists()) { dest.getParentFile().mkdir(); }

        try {
            //上传文件
            file.transferTo(dest); //保存文件
            System.out.print("保存图片文件路径"+path+"\n");
            imgkind=fileName;//本地运行项目
        } catch (IOException e) {
            return "0";
        }

        if(cover_kind.equals("background_cover"))
            fileUploadService.alterBackcover(u_id,imgkind);
        else if(cover_kind.equals("head_cover"))
            fileUploadService.alterHeadcover(u_id,imgkind);


        return "1";
    }


}

