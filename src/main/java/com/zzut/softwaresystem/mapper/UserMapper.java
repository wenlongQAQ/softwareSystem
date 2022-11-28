package com.zzut.softwaresystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzut.softwaresystem.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
