package org.kt.temp.service.impl;

import org.kt.temp.dao.ClientDao;
import org.kt.temp.pojo.Client;
import org.kt.temp.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDao clientDao;


    @Override
    public List<Client> findAll(Client client) {
        // 计算分页
        Integer page = (client.getPage()-1)*client.getLimit();
        client.setPage(page);
        return clientDao.findAll(client);
    }

    @Override
    public void saveOrUpdate(Client client) {
        clientDao.saveOrUpdate(client);
    }

    @Override
    public long count(Client client) {
        return clientDao.count(client);
    }
}
