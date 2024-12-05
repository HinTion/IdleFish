package com.mySchool.entity;

import lombok.*;

/**
 * java 版本 "11.0.22" 2024-01-16 LTS
 * @author: Hinton
 * 创建时间: 2024-09-04 下午1:20
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result<T> {
    private Integer code; // 1 win  0 lose
    private String message;
    private T data;

    // 快速返回成功响应结果
    public static <E> Result<E> success(E data) {
        return new Result<>(1, "操作成功", data);
    }

    //
    public static <E> Result<E> success() {
        return new Result<>(1, "操作成功", null);
    }
    public static Result error(String message){
        return new Result(0, message, null);
    }
}
