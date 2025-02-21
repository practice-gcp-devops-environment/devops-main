package org.example.devopsmain.service;

import lombok.RequiredArgsConstructor;
import org.example.devopsmain.entity.RedisEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {
    private static final String KEY = "Redis";

    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations<String, String, RedisEntity> hashOperations;
    private final RedisConnectionFactory redisConnectionFactory;

    @Autowired
    public RedisService(RedisTemplate<String, Object> redisTemplate, RedisConnectionFactory redisConnectionFactory) {
        this.redisTemplate = redisTemplate;
        this.hashOperations = redisTemplate.opsForHash();
        this.redisConnectionFactory = redisConnectionFactory;
    }

    public void saveUser(RedisEntity redisEntity) {
        hashOperations.put(KEY, redisEntity.getId(), redisEntity);
    }

    public RedisEntity findUserById(String id) {
        return hashOperations.get(KEY, id);
    }

    public void deleteUser(String id) {
        hashOperations.delete(KEY, id);
    }

    public void testRedisConnection() {
        String pingResponse = redisConnectionFactory.getConnection().ping();
        System.out.println("✅ Redis 연결 상태: " + pingResponse);
    }
}
