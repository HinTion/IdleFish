package com.idlefish.mapper;

import com.idlefish.pojo.*;
import org.apache.ibatis.annotations.*;

import java.util.*;

/**
* @author : Hinton
* @date : 2024/11/2 上午9:34
*/
@Mapper
public interface UserMapper {

    Long login(String account, String password);

    Long register(User user);

    User deleteById(Long id);

    Long update(User u);

    User queryUserById(Long id);


    User queryInfo(String account);

    User queryByName(String name);

    // 我收藏
    List<Long> queryCollectionIds(Long id);

    // 我历史浏览
    List<Long> queryBrowseHistoryIds(Long id);

    // 我关注
    List<Long> queryFollowToIds(Long id);

    List<UserFollowTo> queryFollowToInfo(List<Long> ids);

    // 我粉丝
    List<Long> queryFansIds(Long id);

    /*
     */
    // 我发布的
    List<Long> queryMyPostIds(Long id);

    // 我卖出的
    List<Long> queryMySoldIds(Long id);

    // 我卖出的
    List<Long> queryMyPurchasedIds(Long id);




    /**
     * 查询xxx数量
     * @param id 当前用户ID
     * @return xxx的数量
     */
    int queryFollowNum(Long id);

    int queryFansNum(Long id);

    int queryCollectionNum(Long id);

    int queryBrowseNum(Long id);

    int queryMyPostNum(Long id);

    int queryMySoldNum(Long id);

    int queryMyBoughtNum(Long id);
}
