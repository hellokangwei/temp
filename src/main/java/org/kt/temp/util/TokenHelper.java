package org.kt.temp.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.kt.temp.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.io.IOException;

/**
 * Token生成工具类
 */
@Component
public class TokenHelper {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * 创建token
     * @param user 用户对象
     */
    public String createToken(User user) {
        String token = UUIDUtil.getRandom32PK(); // 生成token
        Jedis jedis = redisUtil.getJedis();
        try {
            String userJson = objectMapper.writeValueAsString(user);
            String newLoginKey = Constans.LOGIN_TOKEN_KEY_PREFIX+token;
            jedis.set(newLoginKey,userJson);
            jedis.expire(newLoginKey,Constans.TOKEN_EXPIRES_SECOND); // 设置过期时间
            jedis.close();
            return token;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 检查token是否存在，存在则更新过期时间
     * @param token 用户携带的token
     */
    public User checkToken(String token) {
        String newTokenyKey = Constans.LOGIN_TOKEN_KEY_PREFIX+token;
        User user = null;
        if(token != null) {
            Jedis jedis = redisUtil.getJedis();
            // 判断是否存在该tokenKey
            Boolean result = jedis.exists(newTokenyKey);
            if(result) {
                String userJson = jedis.get(newTokenyKey);
                try {
                    user = objectMapper.readValue(userJson, User.class);
                    jedis.expire(newTokenyKey,Constans.TOKEN_EXPIRES_SECOND);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            jedis.close();
        }
        return user;
    }


}
