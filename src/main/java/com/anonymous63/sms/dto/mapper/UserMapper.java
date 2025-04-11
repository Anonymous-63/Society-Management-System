package com.anonymous63.sms.dto.mapper;

import com.anonymous63.sms.dto.UserDto;
import com.anonymous63.sms.entity.Role;
import com.anonymous63.sms.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {
    //Entity -> Dto
    @Mapping(target = "roles", source = "roles", qualifiedByName = "mapRolesToStrings")
    UserDto toDto(User user);

    List<UserDto> toDtoList(List<User> users);

    // Dto -> Entity
    @Mapping(target = "roles", source = "roles", qualifiedByName = "mapStringsToRoles")
    User toEntity(UserDto userDto);

    List<User> toEntityList(List<UserDto> userDtos);

    @Named("mapRolesToStrings")
    default Set<String> mapRoles(Set<Role> roles) {
        return roles.stream().map(Role::getName).collect(Collectors.toSet());
    }

    @Named("mapStringsToRoles")
    default Set<Role> mapRolesFromString(Set<String> roles) {
        if (roles == null) return new HashSet<>();
        return roles.stream().map(roleName -> {
            Role role = new Role();
            role.setName(roleName);
            return role;
        }).collect(Collectors.toSet());
    }
}
