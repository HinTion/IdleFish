package com.idlefish.pojo;

import lombok.*;

/**
* @author : Hinton
* @时间 : 2024/12/2 下午6:40
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MeCollection {
    private Long id;

    private Long userId;

    private Long collectionId;

    private String collectionName;
}
