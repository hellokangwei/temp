package org.kt.temp.dao;

import org.kt.temp.pojo.Client;

import java.util.List;

public interface ClientDao {

    List<Client> findAll(Client client);

    void saveOrUpdate(Client client);

    long count(Client client);

}
