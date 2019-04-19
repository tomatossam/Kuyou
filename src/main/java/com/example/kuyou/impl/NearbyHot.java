package com.example.kuyou.impl;

import com.example.kuyou.object.HotNearby;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@ComponentScan
public class NearbyHot {
    private JdbcOperations jdbcOperations;

    // 查询location对应的多个热门标签，小范围优先, 没有去重
    private static final String SELECT_POSITION =
            "select l_id, l_content, l_kind from label,view " +
                    "where label.view_id = view.view_id and " +
                    "view.country = ? and view.province = ? and " +
                    "view.city = ? and view.place = ? and " +
                    "view.position = ? and label_use_num > 1000;";

    // 查询location对应的多个范围更大的热门标签
    private static final String SELECT_PLACE =
            "select l_id, l_content, l_kind from label,view " +
                    "where label.view_id = view.view_id and " +
                    "view.country = ? and view.province = ? and " +
                    "view.city = ? and view.place = ? and view.position <> ? " +
                    "and label_use_num > 1000;";


    @Autowired
    public NearbyHot(JdbcOperations jdbcOperations){
        this.jdbcOperations = jdbcOperations;
    }

    public List<HotNearby> getHotNearby(String location){
        String[] des = location.split("·");
        RowMapper<HotNearby> rowMapper = new BeanPropertyRowMapper<>(HotNearby.class);
        List<HotNearby> hotNearbyList1 = jdbcOperations.query(SELECT_POSITION, rowMapper,
                new Object[]{des[0], des[1], des[2], des[3], des[4]});

        List<HotNearby> hotNearbyList2 = jdbcOperations.query(SELECT_PLACE, rowMapper,
                    new Object[]{des[0], des[1], des[2], des[3], des[4]});
        hotNearbyList1.addAll(hotNearbyList2);
        return hotNearbyList1;
    }
}
