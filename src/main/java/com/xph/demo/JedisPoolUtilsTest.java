package com.xph.demo;

import com.xph.util.JedisPoolUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolUtilsTest {

    /**
     * jedis连接池的使用
     */
    @Test
    public void Test7(){
        //0.创建一个配置对象
        JedisPoolConfig config =new JedisPoolConfig();
        config.setMaxTotal(50);
        config.setMaxIdle(10);

        //1.创建Jedis连接池对象
        JedisPool jedisPool = new JedisPool(config,"localhost",6379);

        //2.获取连接
        Jedis jedis = jedisPool.getResource();
        //3.使用
        jedis.set("username","xph");
        //4.关闭 归还到连接池中
        jedis.close();
    }

    /**
     * jedis连接池工具类的使用
     */
    @Test
    public void JedisPoolUtilsTest(){
        //通过连接池工具类获取
        Jedis jedis = JedisPoolUtils.getJedis();
        //3.使用
        jedis.set("hello","world");
        //4.关闭 归还到连接池中
        jedis.close();
    }
}
