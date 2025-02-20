package org.example.devopsmain.repository;

import org.example.devopsmain.entity.HelloEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HelloRepository extends JpaRepository<HelloEntity, Long> {
}
