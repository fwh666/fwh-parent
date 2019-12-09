package com.fuwenhao;

import com.fuwenhao.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedisApi {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * String类型操作
     *
     * @param
     * @return void
     * @author fwh
     * @date 2019/11/23 16:44
     */
    @Test
    public void stringOperator() {
        //设置数据库
        JedisConnectionFactory jedisConnectionFactory = (JedisConnectionFactory) stringRedisTemplate.getConnectionFactory();
        jedisConnectionFactory.setDatabase(2);
        //存储
        stringRedisTemplate.opsForValue().set("fwhKey", "fwhValue", 1, TimeUnit.DAYS);//失效时间
        //取值
        String fwhKey = stringRedisTemplate.opsForValue().get("fwhKey");
        //删除
        stringRedisTemplate.delete("fwhKey");
        System.out.println(fwhKey);
    }

    /**
     * hash类型操作
     *
     * @param
     * @return void
     * @author fwh
     * @date 2019/11/23 16:48
     */
    @Test
    public void hashOperator() {
        String hashKey = "hashKey", stringKey = "stringKey", stringValue = "stringValue";
        //存储
        redisTemplate.opsForHash().put(hashKey, stringKey, stringValue);
        redisTemplate.opsForHash().put(hashKey, "stringKey2", "stringValue2");
        //失效时间
        redisTemplate.expire(hashKey, 1, TimeUnit.DAYS);
        //取值
        System.out.println(redisTemplate.opsForHash().get(hashKey, stringKey));
        System.out.println(redisTemplate.opsForHash().get(hashKey, "stringKey2"));
        //删除
        System.out.println(redisTemplate.opsForHash().delete(hashKey, "stringKey2"));
    }


    @Test
    public void test() throws Exception {
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
    }

    @Test
    public void testObj() throws Exception {
        User user = new User("aa@126.com", "aa", "aa123456", "aa", "123");
        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        operations.set("com.neox", user);
        operations.set("com.neo.f", user, 1, TimeUnit.SECONDS);
        Thread.sleep(1000);
        //redisTemplate.delete("com.neo.f");
        boolean exists = redisTemplate.hasKey("com.neo.f");
        if (exists) {
            System.out.println("exists is true");
        } else {
            System.out.println("exists is false");
        }
        // Assert.assertEquals("aa", operations.get("com.neo.f").getUserName());
    }
}