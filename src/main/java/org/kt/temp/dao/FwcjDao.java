package org.kt.temp.dao;

import org.kt.temp.pojo.Fwcj;

import java.util.List;

/**
 * 房屋采集
 */
public interface FwcjDao {

    void addFwcj(Fwcj fwcj);

    List<Fwcj> list();

}
