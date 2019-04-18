package org.kt.temp.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TempTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void test(){

        String sql = "select * from sys_client";
        jdbcTemplate.query(sql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                String clientname = rs.getString("clientname");
                Date lrsj = rs.getTimestamp("lrsj");
                System.out.println(clientname);
                System.out.println(lrsj);
            }
        });


    }

}
