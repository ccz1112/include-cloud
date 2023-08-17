package com.include.comm.annotation;



/**
* @param:
* @methoName:
* @return:
* @date: 2023-02-24 14:47
* @author: cs
* @Description:
*/
@FunctionalInterface
public interface PoolDataFunction<T,R> {

    R apply(T t);
}
