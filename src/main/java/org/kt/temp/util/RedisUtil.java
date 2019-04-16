package org.kt.temp.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * redis工具
 */
public class RedisUtil {

    // 声明一个连接池对象
    private JedisPool jedisPool;

    // 初始化连接池
    public void initJedisPool(String host,int port,int database){
        // 声明一个连接池配置对象
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();

        // 总数
        jedisPoolConfig.setMaxTotal(200);
        // 获取连接时等待的最大毫秒
        jedisPoolConfig.setMaxWaitMillis(10*1000);
        // 最少剩余数
        jedisPoolConfig.setMinIdle(10);
        // 如果到最大数，设置等待
        jedisPoolConfig.setBlockWhenExhausted(true);
        // 等待时间
        jedisPoolConfig.setMaxWaitMillis(2000);
        // 在获取连接时，检查是否有效
        jedisPoolConfig.setTestOnBorrow(true);

        // 创建连接池
        jedisPool = new  JedisPool(jedisPoolConfig,host,port,20*1000);
    }

    // 获取jedis数据源
    public Jedis getJedis(){
        // 获取连接池
        Jedis jedis = jedisPool.getResource();
        return jedis;
    }
}
