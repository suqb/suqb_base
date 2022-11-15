package com.xxx.springboot.controller;

import com.github.pagehelper.PageInfo;
import com.xxx.springboot.exceptions.ParamsExceptions;
import com.xxx.springboot.po.vo.ResultInfo;
import com.xxx.springboot.po.User;
import com.xxx.springboot.query.UserQuery;
import com.xxx.springboot.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Swagger使用
 *      用于请求的类，说明该类的作用
 *          tags="说明该类的作用"
 *
 *      ApiOperation:用在请求方法上说明该方法的作用
 * 	        value="说明该方法的作用"
 * 	        notes="备注"
 *
 *       ApiImplicitParams:用在请求方法上，包含一组说明
 * 	        ApiImplicitParam:用在ApiImplicitParams注解中，指定请求参数的信息
 * 		        name:参数名
 * 		        value:参数的解析
 * 		        required:参数是否必须传
 * 		        paramType:参数放在什么地方
 *                  .header -->请求参数的获取:@RequestHeader
 *                  .query --->请求参数的获取:@RequestParam
 *                  .path ---->请求参数的获取:@pathVariable
 *                  .body ---->
 *                  .form ---->
 *              dataType: 参数类型，默认String其他值DateType="Integer"
 *              defaultValue:参数的默认值
 */
@Api(tags = "用户模块")
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @ApiOperation(value = "根据用户名查询用户对象", notes = "用户名不能为空!")
    @GetMapping("user/{username}")
    public User queryUserByUserName(@PathVariable String username) {

        System.out.println(username + "===========================================>");

        return userService.queryUserByUserName(username);
    }

    @ApiOperation(value = "根据用户id查询用户对象")
    @GetMapping("/user/id/{userId}")
    public User queryUserById(@PathVariable Integer userId) {
        return userService.queryById(userId);
    }

    @ApiOperation(value = "添加用户")
    @PutMapping("/user")
    public ResultInfo saveUser(User user) {

        ResultInfo resultInfo = new ResultInfo();

        try {

            userService.saveUser(user);

        } catch (ParamsExceptions e) {

            e.printStackTrace();

            resultInfo.setCode(e.getCode());
            resultInfo.setMsg(e.getMsg());

        } catch (Exception e) {

            e.printStackTrace();

            resultInfo.setCode(300);
            resultInfo.setMsg("添加用户失败!");
        }
        return resultInfo;
    }

    @ApiOperation(value = "根据id更新用户信息")
    @PostMapping("/user")
    public ResultInfo updateUser(User user) {

        ResultInfo resultInfo = new ResultInfo();

        System.out.println(user + "==========================================================>");

        try {

            userService.updateUser(user);

        } catch (ParamsExceptions e) {

            e.printStackTrace();

            resultInfo.setCode(e.getCode());
            resultInfo.setMsg(e.getMsg());

        }catch (Exception e) {

            e.printStackTrace();

            resultInfo.setCode(300);
            resultInfo.setMsg("更新记录失败!");
        }

        return resultInfo;
    }

    @ApiOperation(value = "根据id删除用户")
    @DeleteMapping("/user")
    public ResultInfo deleteUser(Integer id) {

        ResultInfo resultInfo = new ResultInfo();

        try {

            userService.deleteUser(id);

        } catch (ParamsExceptions e) {

            e.printStackTrace();

            resultInfo.setCode(e.getCode());
            resultInfo.setMsg(e.getMsg());

        }catch (Exception e) {

            e.printStackTrace();

            resultInfo.setCode(300);
            resultInfo.setMsg("删除记录失败!");
        }

        return resultInfo;
    }

    @ApiOperation(value = "模糊查询查询用户列表", notes = "无参即查询全部用户")
    @GetMapping("/user/list")
    public PageInfo<User> queryUserByParams(UserQuery userQuery) {

        return userService.queryUserByParams(userQuery);
    }

    @RequestMapping("/test")
    public String test() {
        return "test";
    }

}
