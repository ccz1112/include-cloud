package com.include.comm.entity;

import com.include.comm.enumeratr.HttpCodeEnum;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ author: chenshuo
 * @ Date: 2022/2/28
 * @ Time: 10:55
 * @ version： 1.0
 * @ Description:
 **/
@Data
@Builder
@NoArgsConstructor
public class R<T> implements Serializable {

    private Integer code;
    private String msg;
    private T data;


    public R(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public R(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public static R error(){
        return new R(HttpCodeEnum.ERROR.getCode(),HttpCodeEnum.ERROR.getMsg());
    }

    public static  R error(Integer code ,String msg){
        return new R(code,msg);
    }

    public static <T> R error(Integer code ,String msg, T data){
        return new R(code,msg,data);
    }

    public static <T> R error(T data){
        return new R(HttpCodeEnum.ERROR.getCode(),HttpCodeEnum.ERROR.getMsg(),data);
    }

    public static R oK(){
        return new R(HttpCodeEnum.SUCCESS.getCode(),HttpCodeEnum.SUCCESS.getMsg());
    }
    public static <T> R<T> oK(T data){
        return new R(HttpCodeEnum.SUCCESS.getCode(),HttpCodeEnum.SUCCESS.getMsg(),data);
    }
}