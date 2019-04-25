package org.kt.temp.action;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import org.kt.temp.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 微信小程序登录验证
 */
@RequestMapping("/api/v1/login")
@RestController
public class WxLoginAct {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private OkHttpClient okHttpClient;

    @RequestMapping("/doLogin")
    public ResultData wxLogin(String jsCode) {
        try {
            Map<String, Object> map = HttpUtils.wxLogin(jsCode, okHttpClient, objectMapper);
            if(map != null) return ResultData.success(map);
        } catch (Exception e) {}
        return ResultData.error();
    }

}
