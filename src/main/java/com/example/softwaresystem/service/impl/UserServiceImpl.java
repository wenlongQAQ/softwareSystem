package com.example.softwaresystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.softwaresystem.entity.User;
import com.example.softwaresystem.mapper.UserMapper;
import com.example.softwaresystem.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
