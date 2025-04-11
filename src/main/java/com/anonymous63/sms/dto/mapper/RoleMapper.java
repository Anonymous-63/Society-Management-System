package com.anonymous63.sms.dto.mapper;

import com.anonymous63.sms.dto.RoleDto;
import com.anonymous63.sms.entity.Privilege;
import com.anonymous63.sms.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    //Entity -> Dto
    @Mapping(target = "privileges", source = "privileges", qualifiedByName = "mapPrivilegesToStrings")
    RoleDto toDto(Role role);

    List<RoleDto> toDtoList(List<Role> roles);

    // Dto -> Entity
    @Mapping(target = "privileges", source = "privileges", qualifiedByName = "mapStringsToPrivileges")
    Role toEntity(RoleDto roleDto);

    List<Role> toEntityList(List<RoleDto> roleDtos);

    @Named("mapPrivilegesToStrings")
    default Set<String> mapPrivileges(Set<Privilege> privileges) {
        return privileges.stream().map(Privilege::getName).collect(Collectors.toSet());
    }

    @Named("mapStringsToPrivileges")
    default Set<Privilege> mapPrivilegesFromString(Set<String> privileges) {
        if (privileges == null) return new HashSet<>();
        return privileges.stream().map(privilegeName -> {
            Privilege privilege = new Privilege();
            privilege.setName(privilegeName);
            return privilege;
        }).collect(Collectors.toSet());
    }
}
