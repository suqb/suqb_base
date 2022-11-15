package com.xxx.springboot.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "用户查询对象")
public class UserQuery {

    @ApiModelProperty(value = "分页码数", example = "1")
    private Integer pageNumber = 1;
    @ApiModelProperty(value = "单页数量", example = "10")
    private Integer pageSize = 10;
    @ApiModelProperty(value = "用户名")
    private String userName;

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
