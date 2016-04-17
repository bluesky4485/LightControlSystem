package com.gaogandeng.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.SortParameters;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by lanxing on 16-3-28.
 */

@Service("redisService")
public class RedisService{

    private RedisTemplate redisTemplate ;

    @Autowired
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 向键为key的链表中插入vallue，按照左插入的方式, 并对其进行排序
     * @param key redis中的键值
     * @param value  需要插入的至
     * @return 链表中值的个数
     */
    public Long pushTimeCmd(final String key, String value) {
        Long len = redisTemplate.opsForList().leftPush(key, value);

        RedisSort redisSort = RedisSort.getRedisSort();
        redisSort.setKey(key);
        redisSort.setOrder(SortParameters.Order.ASC);
        redisSort.setAlphabetic(true);
        redisTemplate.sort(redisSort, key);
        return len;
    }

    /**
     * 同上但没有对其排序
     * @param key
     * @param value
     * @return
     */
    public Long pushCmd(final String key, String value){
        Long len = redisTemplate.opsForList().leftPush(key, value);
        return len;
    }

    public void insertMap(final String key, String index, String value){
        if(!redisTemplate.opsForHash().hasKey(key, index)){
            redisTemplate.opsForHash().put(key, index, value);
            return;
        }
        String tmp = getMapValue(key, index);
        tmp = tmp + ";" + value;
        deleteMap(key, index);
        redisTemplate.opsForHash().put(key, index, tmp);
    }

    public String getMapValue(final String key, String index){
        return (String)redisTemplate.opsForHash().get(key, index);
    }

    public void deleteMap(final String key, String index){
        redisTemplate.opsForHash().delete(key, index);
    }

    /**
     * 从键为key的链表中左侧弹出数据
     * @param key
     * @return
     */
    public String popCmd(String key){
        return (String)redisTemplate.opsForList().leftPop(key);
    }
}
