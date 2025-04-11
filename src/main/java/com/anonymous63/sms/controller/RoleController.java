package com.anonymous63.sms.controller;

import com.anonymous63.sms.dto.RoleDto;
import com.anonymous63.sms.payload.ApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("role")
public class RoleController implements CrudController<RoleDto, Long> {
    @Override
    public ApiResponse<RoleDto> get(Long aLong) {
        return null;
    }

    @Override
    public ApiResponse<List<RoleDto>> getAll() {
        return null;
    }

    @Override
    public ApiResponse<RoleDto> save(RoleDto roleDto) {
        return null;
    }

    @Override
    public ApiResponse<RoleDto> update(RoleDto roleDto, Long aLong) {
        return null;
    }

    @Override
    public ApiResponse<?> delete(Long aLong) {
        return null;
    }

    @Override
    public ApiResponse<?> deleteAll() {
        return null;
    }
}
