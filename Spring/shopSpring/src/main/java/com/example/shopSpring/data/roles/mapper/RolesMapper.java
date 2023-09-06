package com.example.shopSpring.data.roles.mapper;

import com.example.shopSpring.data.roles.model.Roles;
import com.example.shopSpring.data.roles.model.RolesDto;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface RolesMapper {

    RolesDto toDto(Optional<Roles> source);
    RolesDto toDto(Roles source);
    List<RolesDto> toDtoList(List<Roles> source);
    Roles fromDto(RolesDto destination);
}
