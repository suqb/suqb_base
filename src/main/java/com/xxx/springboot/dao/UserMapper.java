package com.xxx.springboot.dao;

import com.xxx.springboot.po.User;
import com.xxx.springboot.query.UserQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    User queryUserByUserName(String userName);

    User queryById(Integer id);

    int save(User user);

    int update(User user);

    int deleteUser(Integer id);

    List<User> selectUserByPrams(UserQuery userQuery);
}
