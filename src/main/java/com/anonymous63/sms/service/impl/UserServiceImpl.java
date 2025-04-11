package com.anonymous63.sms.service.impl;

import com.anonymous63.sms.dto.UserDto;
import com.anonymous63.sms.dto.mapper.UserMapper;
import com.anonymous63.sms.entity.User;
import com.anonymous63.sms.exception.handler.ResourceNotFoundException;
import com.anonymous63.sms.repository.UserRepo;
import com.anonymous63.sms.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final UserMapper mapper;

    public UserServiceImpl(UserRepo userRepo, UserMapper mapper) {
        this.userRepo = userRepo;
        this.mapper = mapper;
    }

    @Override
    public UserDto get(Long id) {
        User user = this.userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with Id: " + id));
        return mapper.toDto(user);
    }

    @Override
    public List<UserDto> getAll() {
        List<User> users = this.userRepo.findAll();
        return mapper.toDtoList(users);
    }

    @Override
    public UserDto save(UserDto userDto) {
        User user = mapper.toEntity(userDto);
        User saveUser = userRepo.save(user);
        System.out.println("Id" + saveUser.getId());
        return mapper.toDto(saveUser);
    }

    @Override
    public UserDto update(UserDto userDto, Long id) {
        User existingUser = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with Id: " + id));
        existingUser.setFirstName(userDto.getFirstName());
        existingUser.setLastName(userDto.getLastName());
        existingUser.setEmail(userDto.getEmail());
        return mapper.toDto(existingUser);
    }

    @Override
    public void delete(Long id) {
        User existingUser = this.userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with Id: " + id));
        this.userRepo.delete(existingUser);
    }

    @Override
    public void deleteAll() {
        List<User> users = this.userRepo.findAll();
        if (!users.isEmpty()){
            this.userRepo.deleteAll();
        }
    }
}

