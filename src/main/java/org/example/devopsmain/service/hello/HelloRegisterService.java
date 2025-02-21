package org.example.devopsmain.service.hello;

import lombok.RequiredArgsConstructor;
import org.example.devopsmain.common.property.HelloInfoProperty;
import org.example.devopsmain.dto.HelloDto;
import org.example.devopsmain.dto.HelloRequestDto;
import org.example.devopsmain.dto.HelloResponseDto;
import org.example.devopsmain.service.hello.persistence.HelloService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HelloRegisterService {
    private final HelloService helloService;
    private final HelloInfoProperty helloInfoProperty;

    public HelloResponseDto register(HelloRequestDto helloRequestDto) {
        HelloDto helloDto = HelloDto.builder()
                .helloName(helloRequestDto.getHelloName())
                .helloPassword(helloRequestDto.getHelloPassword())
                .helloImage(helloInfoProperty.getUrl())
                .build();
        HelloDto savedDto = helloService.save(helloDto);
        return HelloResponseDto.builder()
                .helloId(savedDto.getHelloId())
                .helloName(savedDto.getHelloName())
                .helloPassword(savedDto.getHelloPassword())
                .helloImage(savedDto.getHelloImage())
                .build();
    }
}
