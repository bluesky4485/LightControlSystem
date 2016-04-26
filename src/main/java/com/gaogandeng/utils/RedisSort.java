package com.gaogandeng.utils;

import org.springframework.data.redis.connection.SortParameters;
import org.springframework.data.redis.core.query.SortQuery;

import java.io.Serializable;
import java.util.List;

/**
 * 用于链表排序
 * Created by lanxing on 16-3-29.
 */
public class RedisSort implements SortQuery, Serializable{
    private static final long serialVersionUID = -2339358731814674971L;
    private Object key;
    private SortParameters.Order order;
    private SortParameters.Range range;
    private Boolean alphabetic;

    public void setAlphabetic(Boolean alphabetic) {
        this.alphabetic = alphabetic;
    }

    public void setRange(SortParameters.Range range) {
        this.range = range;
    }

    public void setOrder(SortParameters.Order order) {
        this.order = order;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public SortParameters.Order getOrder() {
        return order;
    }

    public Boolean isAlphabetic() {
        return alphabetic;
    }

    public SortParameters.Range getLimit() {
        return range;
    }

    public Object getKey() {
        return key;
    }

    public String getBy() {
        return null;
    }

    public List<String> getGetPattern() {
        return null;
    }

    public static RedisSort getRedisSort(){
        return new RedisSort();
    }
}
