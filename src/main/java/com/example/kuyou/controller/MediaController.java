package com.example.kuyou.controller;

/*
 * author dpc
 * */


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

@RestController
@RequestMapping("media")
public class MediaController {

    @RequestMapping(value = "get", method = RequestMethod.GET)
    public void getMedia(HttpServletRequest request, HttpServletResponse response){
        String kind = request.getParameter("media_request_kind");
        String route = request.getParameter("media_content");
        File file;
        String fileStr = "F:\\kuYou";

        if(kind.equals("COVER_VIDEO")){
            file = new File(fileStr + "\\coverVideo\\" + route);
            sendMedia(response, file, "image/png");
        }else if (kind.equals("COVER_MUSIC")){
            file = new File(fileStr + "\\coverMusic\\" + route);
            sendMedia(response, file, "image/png");
        }else if (kind.equals("COVER_ACTIVITY")){
            file = new File(fileStr + "\\coverActivity\\" + route);
            sendMedia(response, file, "image/png");
        }else if(kind.equals("HEAD")){
            file = new File(fileStr + "\\head\\" + route);
            sendMedia(response, file, "image/png");
        }else if (kind.equals("BACKGROUND")){
            file = new File(fileStr + "\\background\\" + route);
            sendMedia(response, file, "image/png");
        }else if(kind.equals("VIDEO")){
            file = new File(fileStr + "\\video\\" + route);
            sendMedia(response, file, "video/mp4");
        }else if(kind.equals("MUSIC")){
            file = new File(fileStr + "\\music\\" + route);
            sendMedia(response, file, "audio/mp3");
        }
    }

    private void sendMedia(HttpServletResponse response, File file, String type){
        try{
            FileInputStream in = new FileInputStream(file);
            byte[] data = new byte[(int)file.length()];
            int length = in.read(data);
            in.close();

            response.setContentType(type);

            OutputStream out = response.getOutputStream();
            out.write(data);
            out.flush();
            out.close();
        }catch(Exception e){ }
    }
}
