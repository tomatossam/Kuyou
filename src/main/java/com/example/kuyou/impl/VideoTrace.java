package com.example.kuyou.impl;

import com.example.kuyou.function.VideoInfo;
import com.example.kuyou.object.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
@ComponentScan
public class VideoTrace implements VideoInfo {

    private JdbcOperations jdbcOperations;

    private static final String SELECT_VIDEO_TRACE  =
            "select v_id, v_cover, v_content, v_creator, v_date, " +
                    "video.m_id, v_description, v_thumb_num, " +
                    "share_num, common_num, video.view_id, country, " +
                    "province, city, place, position, m_title " +
                    "from video, view, music " +
                    "where video.v_creator = ? and view.view_id = video.view_id " +
                    "and music.m_id = video.m_id " +
                    "order by v_date desc;";

    @Autowired
    public VideoTrace(JdbcOperations jdbcOperations){
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public List<Video> getVideoInfo(long id) {
        RowMapper<Video> rowMapper = new BeanPropertyRowMapper<>(Video.class);
        List<Video> videoList = jdbcOperations.query(SELECT_VIDEO_TRACE, rowMapper,
                new Object[]{id});
        Set<String> countrySet = new HashSet<>();
        for(Video video:videoList){
            countrySet.add(video.getCountry());
        }
        Object[] countries = countrySet.toArray();
        videoList.get(0).setCountries(countries);
        return videoList;
    }
}
