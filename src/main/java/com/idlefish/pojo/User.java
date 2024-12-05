package com.idlefish.pojo;

import lombok.*;
import javax.persistence.*;

/**
* @author : Hinton
* @date : 2024/10/31 下午9:39
*/
@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account")
    private String account;

    @Column(name = "password")
    private String password;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "intro")
    private String intro;

    @Column(name = "sex")
    private int sex;

}