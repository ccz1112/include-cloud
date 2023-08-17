package com.include.comm.enumeratr;

import lombok.Getter;

/**
 * @projectName include
 * @packageName com.include.comm.enumeratr
 * @className HttpCodeEnum
 * @author： chenshuo
 * @version： 1.0
 * @since： 2022/2/28 10:58
 */
@Getter
public enum HttpCodeEnum {

    /***/
    SUCCESS(200,"操作成功"),
    PERMISSION(401,"无操作权限"),
    NOT_FOUND(404,"访问资源不存在"),
    SQL_EXCEPTION(600,"SQL语法错误,请联系开发人员"),
    FUSING(503,"服务器开小差了,请稍后重试"),
    ERROR(500,"操作失败");

    private Integer code;
    private String msg;




    HttpCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
