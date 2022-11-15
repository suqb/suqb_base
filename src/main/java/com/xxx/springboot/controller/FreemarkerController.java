package com.xxx.springboot.controller;

import com.github.pagehelper.PageHelper;
import com.xxx.springboot.dao.UserMapper;
import com.xxx.springboot.po.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class FreemarkerController {

    @Resource
    UserMapper mapper;

    @RequestMapping("/freemarker")
    public String freemarker(Model model) {

        PageHelper.startPage(0,10);

        List<User> userList = mapper.selectUserByPrams(null);

        model.addAttribute("userList",userList);

        return "index";
    }
}
