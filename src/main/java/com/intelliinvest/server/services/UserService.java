package com.intelliinvest.server.services;

import com.intelliinvest.server.payloads.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUser(Integer id);
    List<UserDto> getAll();
    void DeleteUser(Integer id);
    UserDto updateUser(UserDto userDto);
}
