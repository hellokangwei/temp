package org.kt.temp.dao.impl;

import org.kt.temp.dao.FwcjDao;
import org.kt.temp.pojo.Fwcj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class FwcjDaoImpl implements FwcjDao {

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public void addFwcj(Fwcj fwcj) {
        String sql = "insert into test_fwcj(id,zjhm,xm,lxdh,rzsj,xzdz,hjdz) values(?,?,?,?,?,?,?)";

        jdbcTemplate.update(sql,new Object[]{fwcj.getId(),fwcj.getZjhm(),fwcj.getXm(),fwcj.getLxdh(),fwcj.getRzsj(),fwcj.getXzdz(),fwcj.getHjdz()});
    }

    @Override
    public List<Fwcj> list() {
        String sql = "select * from test_fwcj";
        return jdbcTemplate.query(sql, new Object[]{}, new RowMapper<Fwcj>() {

            @Override
            public Fwcj mapRow(ResultSet rs, int rowNum) throws SQLException {
                Fwcj f = new Fwcj();
                f.setId(rs.getLong("id"));
                f.setXm(rs.getString("xm"));
                f.setZjhm(rs.getString("zjhm"));
                f.setLxdh(rs.getString("lxdh"));
                f.setRzsj(rs.getString("rzsj"));
                f.setHjdz(rs.getString("hjdz"));
                f.setXzdz(rs.getString("xzdz"));

                return f;
            }
        });
    }
}
