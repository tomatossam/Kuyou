package com.example.kuyou.impl;

import com.example.kuyou.object.LabelInfor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository
@ComponentScan
public class LabelInfoGet {
    private JdbcOperations jdbcOperations;

    // 查询标签ID和种类
    private static final String SELECT_LABEL =
            "select l_id, l_kind from label where l_content = ?";

    // 查询标签对应的活动
    private static final String SELECT_LABEL_ACTIVITY =
            "select a_id from activity, label where label.l_id = ? and label.l_id = activity.l_id";

    @Autowired
    public LabelInfoGet(JdbcOperations jdbcOperations){
        this.jdbcOperations = jdbcOperations;
    }

    public LabelInfor getLabelInfo(String content){
        RowMapper<LabelInfor> rowMapper = new BeanPropertyRowMapper<>(LabelInfor.class);
        LabelInfor labelInfor = jdbcOperations.queryForObject(SELECT_LABEL, rowMapper,
                new Object[]{content});

        if (labelInfor.getL_kind().equals("ACTIVITY")){
            LabelInfor labelInfor1 = jdbcOperations.queryForObject(SELECT_LABEL_ACTIVITY, rowMapper,
                    new Object[]{labelInfor.getL_id()});
            labelInfor.setA_id(labelInfor1.getA_id());
        }
        return labelInfor;
    }
}
