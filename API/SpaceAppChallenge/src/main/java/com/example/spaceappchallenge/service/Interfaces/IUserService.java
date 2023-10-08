package com.example.spaceappchallenge.service.Interfaces;

import com.example.spaceappchallenge.dto.request.CreateUserDto;
import com.example.spaceappchallenge.dto.response.RespMessage;
import com.example.spaceappchallenge.dto.response.UserDto;

import java.util.Set;

public interface IUserService {
    public UserDto findById(long id);
    public Set<UserDto> findAll();
    public RespMessage addUser(CreateUserDto dto);
    public long deleteUser(long id);
    public long updateUser(long id, UserDto dto);
}
