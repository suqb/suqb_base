package com.xxx.springboot.dao;

import com.xxx.springboot.po.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User queryUserByUserName(String userName);

}
