package com.xxx.springboot.service;

import com.xxx.springboot.StarterApplication;
import com.xxx.springboot.po.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {StarterApplication.class})
public class Service {

    private Logger logger = LoggerFactory.getLogger(Service.class);

    @Resource
    private UserService service;

    @Before
    public void before() {

        System.out.println("单元测试开始=================================================》");
    }

    @Test
    public void test_1() {

        User user = service.queryById(3);

        logger.info("用户记录测试：{}",user);
    }

    @After
    public void after() {

        System.out.println("单元测试结束《=================================================");

    }

}
