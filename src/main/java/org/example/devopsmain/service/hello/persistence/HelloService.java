package org.example.devopsmain.service.hello.persistence;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.devopsmain.dto.HelloDto;
import org.example.devopsmain.mapper.HelloMapper;
import org.example.devopsmain.repository.HelloRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class HelloService {
    private final HelloRepository helloRepository;
    private final HelloMapper helloMapper;

    @Transactional
    public HelloDto save(HelloDto helloDto) {
        return helloMapper.toDto(helloRepository.save(helloMapper.toEntity(helloDto)));
    }

    @Transactional(readOnly = true)
    public HelloDto findById(Long id) {
        return helloMapper.toDto(helloRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("User not found with id : " + id)
        ));
    }
}
