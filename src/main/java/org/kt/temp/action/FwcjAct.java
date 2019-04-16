package org.kt.temp.action;

import org.kt.temp.pojo.Fwcj;
import org.kt.temp.service.FwcjService;
import org.kt.temp.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

/**
 * 房屋采集
 */
@RequestMapping("/api/v1/fwcj")
@RestController
public class FwcjAct {

    @Autowired
    private FwcjService fwcjService;

    @RequestMapping("/add")
    public Object addFwcj(@RequestBody Fwcj fwcj) {
        System.out.println(fwcj);
        try {
            fwcj.setId(System.currentTimeMillis());
            fwcjService.addFwcj(fwcj);
        } catch (Exception e) {}
        return R.ok("添加成功");
    }

    @RequestMapping("/list")
    public Object list() {
        List<Fwcj> list = fwcjService.list();


        return R.ok(list);
    }


}
