package com.anonymous63.sms.controller;

import com.anonymous63.sms.dto.UserDto;
import com.anonymous63.sms.payload.ApiResponse;
import com.anonymous63.sms.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/user")
public class UserController implements CrudController<UserDto, Long> {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ApiResponse<UserDto> get(Long id) {
        UserDto fetchedUser = this.userService.get(id);
        return ApiResponse.<UserDto>builder()
                .status(true)
                .message("User fetched successfully.")
                .data(fetchedUser)
                .build();
    }

    @Override
    public ApiResponse<List<UserDto>> getAll() {
        List<UserDto> fetchedAllUsers = this.userService.getAll();
        return ApiResponse.<List<UserDto>>builder()
                .status(true)
                .message("Users fetched successfully.")
                .data(fetchedAllUsers)
                .build();
    }

    @Override
    public ApiResponse<UserDto> save(UserDto userDto) {
        UserDto createdUser = this.userService.save(userDto);
        return ApiResponse.<UserDto>builder()
                .status(true)
                .message("User created successfully.")
                .data(createdUser)
                .build();
    }

    @Override
    public ApiResponse<UserDto> update(UserDto userDto, Long id) {
        UserDto updatedUser = this.userService.update(userDto, id);
        return ApiResponse.<UserDto>builder()
                .status(true)
                .message("User updated successfully.")
                .data(updatedUser)
                .build();
    }

    @Override
    public ApiResponse<?> delete(Long id) {
        this.userService.delete(id);
        return ApiResponse.builder()
                .status(true)
                .message("User deleted successfully.")
                .build();
    }

    @Override
    public ApiResponse<?> deleteAll() {
        this.userService.deleteAll();
        return ApiResponse.builder()
                .status(true)
                .message("Users deleted successfully.")
                .build();
    }
}
