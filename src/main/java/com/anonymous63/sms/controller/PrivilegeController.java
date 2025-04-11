package com.anonymous63.sms.controller;

import com.anonymous63.sms.dto.PrivilegeDto;
import com.anonymous63.sms.payload.ApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("privilege")
public class PrivilegeController implements CrudController<PrivilegeDto, Long>{
    @Override
    public ApiResponse<PrivilegeDto> get(Long aLong) {
        return null;
    }

    @Override
    public ApiResponse<List<PrivilegeDto>> getAll() {
        return null;
    }

    @Override
    public ApiResponse<PrivilegeDto> save(PrivilegeDto privilegeDto) {
        return null;
    }

    @Override
    public ApiResponse<PrivilegeDto> update(PrivilegeDto privilegeDto, Long aLong) {
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
