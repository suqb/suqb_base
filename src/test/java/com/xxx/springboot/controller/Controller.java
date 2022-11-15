package com.xxx.springboot.controller;

import com.xxx.springboot.StarterApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {StarterApplication.class})
@AutoConfigureMockMvc
public class Controller {

    private Logger logger = LoggerFactory.getLogger(Controller.class);

    @Autowired
    private MockMvc mockMvc;

    /**
     * 查询用户列表
     */
    @Test
    public void apiTest_1() throws Exception {

        //  构建请求
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/user/list")
                .contentType("text/html")   //  指定请求头信息
                .accept(MediaType.APPLICATION_JSON);    //  指定请求的Accept头信息

        //  发送请求，获取返回结果
        ResultActions perform = mockMvc.perform(request);

        //  请求结果校验
        perform.andExpect(MockMvcResultMatchers.status().isOk());

        //  表示执行完后返回相应的结果
        MvcResult mvcResult= perform.andReturn();

        //  得到执行后的相应
        MockHttpServletResponse response = mvcResult.getResponse();

        logger.info("响应状态：{}",response.getStatus());
        logger.info("响应内容：{}",response.getContentAsString());

    }

}
