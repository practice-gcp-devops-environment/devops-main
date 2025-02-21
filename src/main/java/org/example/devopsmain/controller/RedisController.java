package org.example.devopsmain.controller;

import lombok.RequiredArgsConstructor;
import org.example.devopsmain.entity.RedisEntity;
import org.example.devopsmain.service.RedisService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
@RequiredArgsConstructor
public class RedisController {
    private final RedisService redisService;

    @GetMapping("/test")
    public void test() {
        RedisEntity redisEntity = RedisEntity.builder()
                .id("hello")
                .name("chan")
                .age(25)
                .build();
        redisService.saveUser(redisEntity);
    }
}
