package org.kt.temp.config;

import org.kt.temp.util.RedisUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Redis配置类
 */
@Configuration
public class RedisConfig {

    @Value("${spring.redis.host:disabled}")
    private String host;

    @Value("${spring.redis.port:0}")
    private int port;

    @Value("${spring.redis.database:0}")
    private int database;


    @Bean
    public RedisUtil getRedisUtil(){
        // 如果没有配置 Host ，默认值为disabled，如果两者相等，则返回null
        if("disabled".equals(host))  return null;
        RedisUtil redisUtil=new RedisUtil();
        redisUtil.initJedisPool(host,port,database);
        return redisUtil;
    }


}
