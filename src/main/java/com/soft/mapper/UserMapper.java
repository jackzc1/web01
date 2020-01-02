package com.soft.mapper;

import com.soft.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2020/1/2.
 */
public interface UserMapper {
    List<User> findAll();
}
