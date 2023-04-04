package com.example.impermanenceservice.service.impl;

import com.example.impermanenceservice.entity.User;
import com.example.impermanenceservice.repository.UserMapper;
import com.example.impermanenceservice.service.UserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public int signUpUser(User user) {
        return userMapper.signUpUser(user);
    }
}
