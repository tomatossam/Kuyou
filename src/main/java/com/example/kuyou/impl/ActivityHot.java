package com.example.kuyou.impl;

import com.example.kuyou.object.HotActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@ComponentScan
public class ActivityHot {
    private JdbcOperations jdbcOperations;

    private static final String SELECT_HOT_ACTIVITY =
            "select a_id, look_num, activity.l_id, l_content, u_id " +
                    "from activity, label " +
                    "where activity.l_id = label.l_id and l_kind = \"ACTIVITY\" " +
                    "order by look_num desc;";

    @Autowired
    public ActivityHot(JdbcOperations jdbcOperations){
        this.jdbcOperations = jdbcOperations;
    }

    public List<HotActivity> getHotActivities(){
        RowMapper<HotActivity> rowMapper = new BeanPropertyRowMapper<>(HotActivity.class);
        return jdbcOperations.query(SELECT_HOT_ACTIVITY, rowMapper);

    }
}
