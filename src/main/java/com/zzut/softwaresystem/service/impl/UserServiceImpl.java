package com.zzut.softwaresystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzut.softwaresystem.entity.User;
import com.zzut.softwaresystem.mapper.UserMapper;
import com.zzut.softwaresystem.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
