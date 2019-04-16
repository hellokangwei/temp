package org.kt.temp.action;

import org.kt.temp.pojo.Client;
import org.kt.temp.service.ClientService;
import org.kt.temp.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ClientAct {

    @Autowired
    private ClientService clientService;

    @RequestMapping("/list")
    public Object list(Client client){
        List<Client> clientList = clientService.findAll(client);
        Map<String,Object> map = new HashMap<>();
        map.put("data",clientList);
        map.put("count",clientService.count(client));
        return R.ok(map);
    }

    @RequestMapping(value="/saveOrUpdate",method = RequestMethod.POST)
    public R saveOrUpdate(Client client){
        try {
            clientService.saveOrUpdate(client);
            return R.ok();
        } catch (Exception e){
            e.printStackTrace();
        }
        return R.error(-1,"访问错误");
    }

}
