package org.example.devopsmain.common.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "spring.redis")
public class RedisProperty {
    private String host;
    private Integer port;
    private String password;
}
