package com.idlefish.service.Impl;

import com.idlefish.mapper.*;
import com.idlefish.pojo.*;
import com.idlefish.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

/**
* @author : Hinton
* @date : 2024/11/2 上午9:32
*/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public Result<User> login(String account, String password) {
        Result<User> result = new Result<>();
        result.setCode(0);
        User user = new User();
        try {
            Long userId= userMapper.login(account, password);
            // System.out.println("当前操作系统登录用户的ID为：" + userId);

            if(userId == null){
                result.setMessage("用户名或密码错误");
            }else{
                result.setMessage("登录成功");
                result.setCode(1);
                user.setId(userId);
                user.setAccount(account);
                user.setPassword(password);
                result.setData(user);
            }
        } catch (Exception e) {
            result.setMessage(e.getMessage());
            e.printStackTrace();
        }
        System.out.println("登录结果:\n" + result);
        return result;
    }

    @Override
    public Result<User> register(String account, String password) {
        Result<User> result = new Result<>();
        result.setCode(0);
        result.setData(null);
        try {
            User existUser = new User();
            if(existUser != null){
                //如果用户名已存在
                result.setMessage("用户名已存在");

            }else{
                User user = new User();
                user.setAccount(account);
                user.setPassword(password);
                // user.setNickname("昵称未填写");
                Long userId =  userMapper.register(user);
                //System.out.println(user.getId());
                result.setMessage("注册成功");
                result.setCode(1);
                result.setData(user);
            }
        } catch (Exception e) {
            result.setMessage(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public User deleteById(Long id) {
        Result<User> result = new Result<>();
        result.setCode(0);
        result.setData(null);
        if (userMapper.queryUserById(id) != null) {
            userMapper.deleteById(id);
            result.setMessage("删除成功");
        } else {
            result.setMessage("用户不存在");
        }
        return userMapper.deleteById(id);
    }

    @Override
    public User update(User user) {
        long id = userMapper.update(user);
        return null;
    }

    @Override
    public User queryById(Long id) {

        return null;
    }


    @Override
    public User queryInfo(Long id) {
        User userInfo = userMapper.queryUserById(id);
        return userInfo;
    }



    /**
     * 我关注
     * @param
     * @return
     */
    @Override
    public List<UserFollowTo> queryFollowToInfo(List<Long> ids) {
        // 查询当前用户关注的用户UID
        // List<Long> followIds = userMapper.queryFollowToIds(ids);

        // 根据UID查询用户信息
        List<UserFollowTo> list = userMapper.queryFollowToInfo(ids);
        // 查询我关注的人的粉丝数
        for (UserFollowTo uTo : list) {
            uTo.setFollowersNum(userMapper.queryFansNum(uTo.getId()));
        }
        return list;
    }



    @Override
    public List queryBrowseHistory(Long id) {

        return null;
    }




    @Override
    public UserHomePageInfo queryHomepageInfo(Long id) {
        UserHomePageInfo info = new UserHomePageInfo();

        // 从user表里查个人属性
        info.setId(id);
        User u = userMapper.queryUserById(id);
        info.setNickname(u.getNickname());
        info.setAvatar(u.getAvatar());
        info.setIntro(u.getIntro());


        // 查找收藏, 浏览, 关注, 发布, 卖出, 买入
        info.setFansIds(userMapper.queryFansIds(id));
        info.setFollowToIds(userMapper.queryFollowToIds(id));
        info.setCollectionIds(userMapper.queryCollectionIds(id));
        info.setBrowseHistoryIds(userMapper.queryBrowseHistoryIds(id));
        info.setMyPostIds(userMapper.queryMyPostIds(id));
        info.setMySoldIds(userMapper.queryMySoldIds(id));
        info.setMyPurchasedIds(userMapper.queryMyPurchasedIds(id));

        return info;
    }
}
