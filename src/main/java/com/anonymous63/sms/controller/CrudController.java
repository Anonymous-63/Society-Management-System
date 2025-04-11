package com.anonymous63.sms.controller;

import com.anonymous63.sms.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public interface CrudController<DTO, ID> {

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    ApiResponse<DTO> get(@PathVariable ID id);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    ApiResponse<List<DTO>> getAll();

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ApiResponse<DTO> save(@RequestBody DTO dto);

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    ApiResponse<DTO> update(@RequestBody DTO dto,@PathVariable ID id);

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    ApiResponse<?> delete(@PathVariable ID id);

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    ApiResponse<?> deleteAll();


}
