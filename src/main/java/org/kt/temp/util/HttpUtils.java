package org.kt.temp.util;


import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.util.Map;

/**
 * 请求工具类
 */
public class HttpUtils {


    /**
     * 微信小程序登录凭证验证
     * @param jsCode 登录时获取的 code
     * @return 返回session_key 和 openid
     */
    public static Map<String, Object> wxLogin(String jsCode, OkHttpClient okHttpClient, ObjectMapper objectMapper) {
        String url = String.format("https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=%s", Constans.APPID, Constans.APPSECRET, jsCode, Constans.GRANT_TYPE);
        try {
            Request request = new Request.Builder().url(url).build();
            Response response = okHttpClient.newCall(request).execute();
            String result = response.body().string();
            Map<String,Object> map = objectMapper.readValue(result, Map.class);
            return map;
        } catch (Exception e) {
            return null;
        }
    }


}
