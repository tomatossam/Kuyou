package com.example.kuyou.controller;

import com.example.kuyou.function.VideoInfo;
import com.example.kuyou.impl.*;
import com.example.kuyou.object.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("video")
public class VideoController {

    private VideoInfo videoInfo;

    private WebApplicationContext context;

    @Autowired
    public VideoController(WebApplicationContext context){
        this.context = context;
    }

    @RequestMapping(value = "information", method = RequestMethod.GET)
    public List<Video> videoInfo(HttpServletRequest request){
        String kind = request.getParameter("video_request_kind");
        long u_id = Long.parseLong(request.getParameter("u_id"));
        long l_id = Long.parseLong(request.getParameter("l_id"));
        long m_id = Long.parseLong(request.getParameter("m_id"));
        long v_id = Long.parseLong(request.getParameter("v_id"));


        if(kind.equals("VIDEO_RECOMMEND")){         // 首页“推荐”
            videoInfo = context.getBean(VideoRecommend.class);
            return videoInfo.getVideoInfo(u_id);
        }else if (kind.equals("VIDEO_NOTICE")){     // 首页“关注”
            videoInfo = context.getBean(VideoNotice.class);
            return videoInfo.getVideoInfo(u_id);
        }else if (kind.equals("VIDEO_NEARBY")){     // 首页“附近”
            videoInfo = context.getBean(VideoNearby.class);
            return videoInfo.getVideoInfo(l_id);
        }else if (kind.equals("VIDEO_ACTIVITY")){   // 活动
            videoInfo = context.getBean(VideoActivity.class);
            return videoInfo.getVideoInfo(l_id);
        }else if (kind.equals("VIDEO_TRACE")){      // 主页“酷游踪迹”
            videoInfo = context.getBean(VideoTrace.class);
            return videoInfo.getVideoInfo(u_id);
        }else if (kind.equals("VIDEO_WORKS")){      // 主页“作品”
            videoInfo = context.getBean(VideoWorks.class);
            return videoInfo.getVideoInfo(u_id);
        }else if (kind.equals("VIDEO_LIKE")){       // 主页“喜欢”
            videoInfo = context.getBean(VideoLike.class);
            return videoInfo.getVideoInfo(u_id);
        }else if (kind.equals("VIDEO_LABEL")){      // 标签下的短视频
            videoInfo = context.getBean(VideoLabel.class);
            return videoInfo.getVideoInfo(l_id);
        }else if (kind.equals("VIDEO_MUSIC")){      // 同款背景音乐的短视频
            videoInfo = context.getBean(VideoMusic.class);
            return videoInfo.getVideoInfo(m_id);
        }else if (kind.equals("VIDEO_SINGLE")){     // 获取一个短视频信息
            videoInfo = context.getBean(VideoSingle.class);
            return videoInfo.getVideoInfo(v_id);
        }else{
            return null;
        }
    }
}
