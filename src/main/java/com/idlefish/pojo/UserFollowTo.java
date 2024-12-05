package com.idlefish.pojo;

import lombok.*;

import javax.persistence.*;

/**
* @author : Hinton
* @时间 : 2024/12/2 下午3:01
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFollowTo {
    private Long id;

    private String nickname;

    private String avatar;

    private String intro;

    private int followersNum;
}

