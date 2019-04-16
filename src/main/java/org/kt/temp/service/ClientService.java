package org.kt.temp.service;

import org.kt.temp.pojo.Client;

import java.util.List;

public interface ClientService {
    List<Client> findAll(Client client);

    void saveOrUpdate(Client client);

    long count(Client client);
}
