package com.example.demo.redis;

public interface RedisService {
    void setKeyAndValue(String userToken, Long accountID);
    Long getValueByKey(String userToken);
    void deleteByKey(String string);
}
