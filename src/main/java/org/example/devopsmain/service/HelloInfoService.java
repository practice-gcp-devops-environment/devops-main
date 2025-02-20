package org.example.devopsmain.service;

import lombok.RequiredArgsConstructor;
import org.example.devopsmain.dto.HelloDto;
import org.example.devopsmain.service.persistence.HelloService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HelloInfoService {
    private final HelloService helloService;

    public HelloDto getInfo(Long id) {
        return helloService.findById(id);
    }
}
