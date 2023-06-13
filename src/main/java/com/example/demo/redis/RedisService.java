package com.example.demo.redis;

public interface RedisService {
    void setKeyAndValue(String userToken, Long accountID);
}
