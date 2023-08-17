package com.include.comm.exception;

import lombok.Data;

/**
 * @author: chenshuo
 * @Date: 2022-12-14
 * @Time: 16:09
 * @version： 1.0
 * @Description:
 **/
@Data
public class BaseException extends RuntimeException{

    private int code;

    public BaseException(int code) {
        super();
        this.code = code;
    }

    public BaseException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BaseException(String msg) {
        super(msg);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(int code,String msg, Throwable cause) {
        super(msg, cause);
        this.code = code;
    }
}