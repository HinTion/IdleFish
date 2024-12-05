package com.idlefish.controller;

import com.idlefish.pojo.*;
import com.idlefish.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
* @author : Hinton
* @date : 2024/10/31 下午9:47
*/
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result<User> register( String account,  String password) {
        return userService.register(account, password);
    }

    @GetMapping("/login")
    public Result<User> login(@RequestParam String account, @RequestParam String password) {


        return userService.login(account, password);
    }


    /**
     * 返回用户带列表的信息
     * @param id
     * @return
     */
    @GetMapping("/queryHomepageInfo")
    public Result<UserHomePageInfo> queryHomepageInfo(@RequestParam Long id) {
        UserHomePageInfo info = userService.queryHomepageInfo(id);
        if (info == null) {
            return Result.error("未查找到该用户");
        }
        System.out.println(info);
        return Result.success(info);
    }





    /**
     * 查询用户收藏列表
     * @param id 当前用户id
     * @return 返回收藏的商品列表
     */
    @GetMapping("queryCollection")
    public Result<List<User>> queryCollection(@RequestParam Long id) {

        return Result.success();
    }

    /**
     * 查询历史浏览
     * @param id 当前用户id
     * @return 返回查看的历史记录
     */
    @GetMapping("/queryBrowseHistory")
    public Result queryBrowseHistory(@RequestParam Long id) {
        return Result.success();
    }


    /**
     * 用户关注列表
     * @param id 当前用户id
     * @return 返回关注的用户列表
     */
    @PostMapping("/queryFollowTo")
    public Result<List<UserFollowTo>> queryFollowTo(@RequestBody List<Long> ids) {
        List<UserFollowTo> list = userService.queryFollowToInfo(ids);
        if (list == null || list.isEmpty()) {
            return Result.error("用户未关注任何人");
        }
        return Result.success(list);
    }


    @PutMapping("/update")
    public Result<User> update(@RequestBody User user) {
        Result<User> result = new Result<>();
        result.setCode(200);
        result.setData(userService.update(user));
        return result;
    }

    @DeleteMapping("/delete")
    public Result<User>  delete(@RequestParam Long id) {
        Result<User> result = new Result<>();
        result.setCode(200);
        result.setData(userService.deleteById(id));

        return result;
    }



}