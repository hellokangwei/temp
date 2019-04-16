package org.kt.temp.dao.impl;

import org.apache.commons.lang3.StringUtils;
import org.kt.temp.dao.ClientDao;
import org.kt.temp.pojo.Client;
import org.simpleflatmapper.jdbc.spring.JdbcTemplateMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientDaoImpl implements ClientDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private RowMapper<Client> rowMapper = JdbcTemplateMapperFactory.newInstance().ignorePropertyNotFound().newRowMapper(Client.class);

    @Override
    public List<Client> findAll(Client client) {
        String sql = "select bb.* from (select rownum rr,ss.* from (select rownum,tt.* from (select * from sys_client order by id desc) tt) ss where rownum <=? ) bb where rr >?";
        return jdbcTemplate.query(sql,new Object[]{client.getLimit()+client.getPage(),client.getPage()},rowMapper);
    }

    @Override
    public void saveOrUpdate(Client client) {

        if(StringUtils.isEmpty(client.getId())){
            client.setId("5bd180ceaf3"+System.currentTimeMillis());
            String sql = "insert into sys_client(id,clientName,password,scope,authorizedGrantTypes,authorities,remark) values(?,?,?,?,?,?,?)";
            jdbcTemplate.update(sql,new Object[]{client.getId(),client.getClientName(),client.getPassword(),client.getScope(),client.getAuthorizedGrantTypes(),client.getAuthorities(),client.getRemark()});
        } else {
            String sql = "update sys_client set clientName=?,password=?,scope=?,authorizedGrantTypes=?,authorities=?,remark=? where id=?";
            jdbcTemplate.update(sql,new Object[]{client.getClientName(),client.getPassword(),client.getScope(),client.getAuthorizedGrantTypes(),client.getAuthorities(),client.getRemark(),client.getId()});
        }
    }

    @Override
    public long count(Client client) {
        String sql = "select count(*) from sys_client";
        return jdbcTemplate.queryForObject(sql,long.class);
    }
}
