package com.include.comm.enumeratr;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @projectName include-cloud-common
 * @packageName com.include.error
 * @className ErrorEnum
 * @author： chenshuo
 * @version： 1.0
 * @since： 2022-12-13 11:01
 */
@Getter
@AllArgsConstructor
public enum ErrorEnum {

    /****/
    TOKEN_EMPTY_ERROR(1000400,"token为空"),
    TOKEN_VALID_ERROR(1000500,"token已失效"),
    PARAMS_EMPTY_ERROR(1000600,"请填写必填参数"),
    RESOURCE_PERMISSION(1000700,"无访问权限"),
    BUSINESS_ERROR(1000000,""),
    SOLE_ERROR(1000800,"索引数据冲突"),
    ;

    private Integer code;
    private String msg;
}
