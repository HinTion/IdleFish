package com.idlefish.service;

import com.idlefish.pojo.*;
import org.springframework.stereotype.*;

import java.util.*;

/**
* @author : Hinton
* @date : 2024/10/31 下午9:49
*/

@Service
public interface UserService {

    Result<User> login(String account, String password);

    Result<User> register(String account, String password);

    User deleteById(Long id);

    User update(User user);

    User queryById(Long id);

    User queryInfo(Long id);

    List<UserFollowTo> queryFollowToInfo(List<Long> id);

    List queryBrowseHistory(Long id);

    UserHomePageInfo queryHomepageInfo(Long id);
}
