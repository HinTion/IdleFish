package com.idlefish.pojo;

import lombok.*;

import java.util.*;

/**
* @author : Hinton
* @时间 : 2024/12/2 下午7:58
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserHomePageInfo {
    private Long id;

    private String nickname;

    private String avatar;

    private String intro;

    private List<Long> followToIds;

    private List<Long> fansIds;

    private List<Long> collectionIds;

    private List<Long> browseHistoryIds;

    private List<Long> myPostIds;

    private List<Long> mySoldIds;

    private List<Long> myPurchasedIds;
}
