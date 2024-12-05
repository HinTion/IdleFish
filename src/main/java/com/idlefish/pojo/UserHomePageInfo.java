package com.idlefish.pojo;

import lombok.*;

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

    private int collectionNum;

    private int followNum;

    private int fansNum;

    private int myPostNum;

    private int mySoldNum;

    private int myBoughtNum;

}
