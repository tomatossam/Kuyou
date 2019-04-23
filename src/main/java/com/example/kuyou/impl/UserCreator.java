package com.example.kuyou.impl;

import com.example.kuyou.object.Creator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@ComponentScan
public class UserCreator {
    private JdbcOperations jdbcOperations;

    private static final String SELECT_CREATOR =
            "select u_id, head, nick, travel_stat " +
                    "from user where u_id = ?";

    private static final String SELECT = "select f_id from fans " +
            "where u_id = ? and following_id = ?";

    // 查询用户u_id的粉丝
    private static final String SELECT_FNAS =
            "select user.u_id, head, nick from user, fans " +
                    "where fans.u_id = ? and following_id = user.u_id";

    private static class Fans{
        private long f_id;

        public long getF_id() {
            return f_id;
        }

        public void setF_id(long f_id) {
            this.f_id = f_id;
        }
    }

    @Autowired
    public UserCreator(JdbcOperations jdbcOperations){
        this.jdbcOperations = jdbcOperations;
    }

    public Creator getCreator(long u_id, long creator){
        RowMapper<Creator> rowMapper = new BeanPropertyRowMapper<>(Creator.class);
        Creator creator1 = jdbcOperations.queryForObject(SELECT_CREATOR, rowMapper,
                new Object[]{creator});

        creator1.setNotice_kind(getNoticeStat(u_id, creator));
        return creator1;
    }

    // 获取粉丝列表
    public List<Creator> getFans(long u_id){
        RowMapper<Creator> rowMapper = new BeanPropertyRowMapper<>(Creator.class);
        List<Creator> creatorList = jdbcOperations.query(SELECT_FNAS, rowMapper, new Object[]{u_id});

        for (Creator creator : creatorList){
            creator.setNotice_kind(getNoticeStat(u_id, creator.getU_id()));
        }
        return creatorList;
    }
    // 判断每一个作者和APP用户的关注状态
    private String getNoticeStat(long u_id, long creator){
        RowMapper<Fans> rowMapper1 = new BeanPropertyRowMapper<>(Fans.class);
        List<Fans> fansList = jdbcOperations.query(SELECT, rowMapper1, new Object[]{creator, u_id});
        if(fansList.size() != 0){
            fansList = jdbcOperations.query(SELECT, rowMapper1, new Object[]{u_id, creator});
            if(fansList.size() != 0){
                return "NOTICE_TWO";
            }else {
                return "NOTICE_YES";
            }
        }else{
            return "NOTICE_NO";
        }
    }
}