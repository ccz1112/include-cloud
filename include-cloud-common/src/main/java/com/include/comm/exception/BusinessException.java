package com.include.comm.exception;

import com.include.comm.enumeratr.ErrorEnum;

/**
 * @author: chenshuo
 * @Date: 2022-12-14
 * @Time: 16:09
 * @version： 1.0
 * @Description:
 **/
public class BusinessException extends BaseException{

    public BusinessException() {
        super(ErrorEnum.RESOURCE_PERMISSION.getCode());
    }

    public BusinessException(int code,String msg) {
        super(code,msg);
    }
}