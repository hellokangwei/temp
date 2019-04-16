package org.kt.temp.service.impl;

import org.kt.temp.dao.FwcjDao;
import org.kt.temp.pojo.Fwcj;
import org.kt.temp.service.FwcjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FwcjServiceImpl implements FwcjService {

    @Autowired
    private FwcjDao fwcjDao;

    @Override
    public void addFwcj(Fwcj fwcj) {
        fwcjDao.addFwcj(fwcj);
    }

    @Override
    public List<Fwcj> list() {
        return fwcjDao.list();
    }
}
