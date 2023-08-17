package com.include.comm.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @ author: chen
 * @ Date: 2023-03-16
 * @ Time: 17:10
 * @ version： 1.0
 * @ Description:
 **/
@Component
@Slf4j
public class MybatisHandlerConfig implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("进入创建");
        this.setFieldValByName("createTime",new Date(),metaObject);
        this.setFieldValByName("createBy","yjx",metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("进入修改");
        this.setFieldValByName("updateTime",new Date(),metaObject);
        this.setFieldValByName("updateBy","yjx",metaObject);
    }
}
