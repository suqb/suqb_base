package com.xxx.springboot.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxx.springboot.dao.UserMapper;
import com.xxx.springboot.po.User;
import com.xxx.springboot.query.UserQuery;
import com.xxx.springboot.utils.AssertUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User queryUserByUserName(String userName) {
        return userMapper.queryUserByUserName(userName);
    }

    public User queryById(Integer id) {
        return userMapper.queryById(id);
    }

    public void saveUser(User user) {

        AssertUtils.isTrue(StringUtils.isBlank(user.getUserName()), "用户名不能为空!");
        AssertUtils.isTrue(StringUtils.isBlank(user.getUserPwd()), "密码不能为空!");

        AssertUtils.isTrue(
                userMapper.queryUserByUserName(user.getUserName()) != null,
                "用户名已存在!"
        );

        AssertUtils.isTrue(
                userMapper.save(user) < 1,

                "用户记录添加失败!"
        );

    }

    public void updateUser(User user) {

        AssertUtils.isTrue(StringUtils.isBlank(user.getUserName()), "用户名不能为空!");
        AssertUtils.isTrue(StringUtils.isBlank(user.getUserPwd()), "密码不能为空!");

        User temp = userMapper.queryUserByUserName(user.getUserName());

        AssertUtils.isTrue(
                temp != null && !(temp.getId().equals(user.getId())),
                "该用户已存在!");

        AssertUtils.isTrue(
                userMapper.update(user) > 1,
                "用户记录修改失败!");
    }

    public void deleteUser(Integer id) {

        AssertUtils.isTrue(
                id == null || userMapper.queryById(id) == null,
                "该记录不存在!"
        );

        AssertUtils.isTrue(
                userMapper.deleteUser(id) < 1,
                "用户删除失败!"
        );
    }

    public PageInfo<User> queryUserByParams(UserQuery userQuery) {

        PageHelper.startPage(userQuery.getPageNumber(),userQuery.getPageSize());

        return new PageInfo<>(userMapper.selectUserByPrams(userQuery));
    }
}
