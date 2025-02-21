package org.example.devopsmain.entity;

import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("redis")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RedisEntity implements Serializable {

    @Id
    private String id;
    private String name;
    private int age;
}
