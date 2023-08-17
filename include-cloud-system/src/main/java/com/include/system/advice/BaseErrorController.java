package com.include.system.advice;

import com.include.comm.entity.R;
import com.include.comm.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: chenshuo
 * @Date: 2022-12-13
 * @Time: 18:29
 * @version： 1.0
 * @Description:
 **/
@ControllerAdvice
@Slf4j
public class BaseErrorController {

    @ExceptionHandler(value = BusinessException.class)
    public R businessHandler(BusinessException e, HttpServletRequest request){
        log.error("{} {}, 发生业务异常, 原因:{}", request.getMethod(), request.getRequestURI(), e.getMessage());
        return R.error(e.getCode(), e.getMessage());
    }


}