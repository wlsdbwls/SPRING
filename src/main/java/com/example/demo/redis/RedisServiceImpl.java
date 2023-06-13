package com.example.demo.redis;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Slf4j
@Service
@RequiredArgsConstructor
public class RedisServiceImpl implements RedisService{

    final private StringRedisTemplate redisTemplate;

    @Override
    public void setKeyAndValue(String userToken, Long accountID) {
        String accountIdToString = String.valueOf(accountID);
        ValueOperations<String, String> value = redisTemplate.opsForValue();
        value.set(userToken, accountIdToString, Duration.ofMinutes(3));
    }
}
