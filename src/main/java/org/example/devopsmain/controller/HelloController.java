package org.example.devopsmain.controller;

import lombok.RequiredArgsConstructor;
import org.example.devopsmain.dto.HelloDto;
import org.example.devopsmain.dto.HelloRequestDto;
import org.example.devopsmain.dto.HelloResponseDto;
import org.example.devopsmain.service.HelloInfoService;
import org.example.devopsmain.service.HelloRegisterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
@RequiredArgsConstructor
public class HelloController {
    private final HelloRegisterService helloRegisterService;
    private final HelloInfoService helloInfoService;

    @PostMapping("/register")
    public ResponseEntity<HelloResponseDto> register(@RequestBody HelloRequestDto helloRequestDto) {
        return ResponseEntity.ok(helloRegisterService.register(helloRequestDto));
    }

    @GetMapping("/info")
    public ResponseEntity<HelloDto> info(@RequestParam Long id) {
        return ResponseEntity.ok(helloInfoService.getInfo(id));
    }
}
