package com.anonymous63.sms.dto.mapper;

import com.anonymous63.sms.dto.PrivilegeDto;
import com.anonymous63.sms.entity.Privilege;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PrivilegeMapper {
    //Entity -> Dto
    PrivilegeDto toDto(Privilege privilege);

    List<PrivilegeDto> toDtoList(List<Privilege> privileges);

    // Dto -> Entity
    Privilege toEntity(PrivilegeDto privilegeDto);

    List<Privilege> toEntityList(List<PrivilegeDto> privilegeDtos);

}
