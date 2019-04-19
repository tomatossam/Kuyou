package com.example.kuyou.impl;

import com.example.kuyou.object.MessageCommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@ComponentScan
public class CommonMessage {

    private JdbcOperations jdbcOperations;

    // 查询对短视频的评论
    private static final String SELECT_COMMON_VIDEO =
            "select vc_id, vc_content, video_common.v_id, u_id, vc_time," +
                    "vc_date, parent_id from video_common, video " +
                    "where video.v_creator = ? " +
                    "and video.v_id = video_common.v_id " +
                    "and vc_id = parent_id;";

    // 查询对评论回复的评论
    private static final String SELECT_COMMON_COMMON =
            "select vc_id, vc_content, v_id, u_id, vc_time," +
                    "vc_date, parent_id from video_common " +
                    "where parent_id = (select vc_id " +
                    "from video_common where u_id = ?) and " +
                    "vc_id <> parent_id;";

    @Autowired
    public CommonMessage(JdbcOperations jdbcOperations){
        this.jdbcOperations = jdbcOperations;
    }

    public List<MessageCommon> getMessageCommons(long u_id){
        RowMapper<MessageCommon> rowMapper = new BeanPropertyRowMapper<>(MessageCommon.class);
        List<MessageCommon> messageCommonList1 = jdbcOperations.query(SELECT_COMMON_VIDEO,
                rowMapper,new Object[]{u_id});
        List<MessageCommon> messageCommonList2 = jdbcOperations.query(SELECT_COMMON_COMMON,
                rowMapper, new Object[]{u_id});
        messageCommonList1.addAll(messageCommonList2);
        return messageCommonList1;
    }
}
