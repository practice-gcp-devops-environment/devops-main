package org.example.devopsmain.mapper;

import org.example.devopsmain.common.mapper.GenericMapper;
import org.example.devopsmain.dto.HelloDto;
import org.example.devopsmain.entity.HelloEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HelloMapper extends GenericMapper<HelloDto, HelloEntity> {
}
