package com.example.kuyou.impl;

import com.example.kuyou.function.VideoInfo;
import com.example.kuyou.object.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@ComponentScan
public class VideoNearby implements VideoInfo {
    private JdbcOperations jdbcOperations;

    private static final String SELECT_VIDEO_MUSIC  =
            "select video.v_id, v_cover, v_content, v_creator, v_date, " +
                    "video.m_id, v_description, v_thumb_num, " +
                    "share_num, common_num, video.view_id, country, " +
                    "province, city, place, position, m_title " +
                    "from video, view, music, join_label " +
                    "where join_label.l_id = ? and video.v_id = join_label.v_id " +
                    "and view.view_id = video.view_id " +
                    "and music.m_id = video.m_id " +
                    "order by v_thumb_num desc;";

    @Autowired
    public VideoNearby(JdbcOperations jdbcOperations){
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public List<Video> getVideoInfo(long id) {
        RowMapper<Video> rowMapper = new BeanPropertyRowMapper<>(Video.class);
        return jdbcOperations.query(SELECT_VIDEO_MUSIC,rowMapper, new Object[]{id});
    }
}
