package com.include.comm.util;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: chenshuo
 * @Date: 2022/3/10
 * @Time: 11:47
 * @version： 1.0
 * @Description:
 **/
@Slf4j
public class ThreadPoolUtils {



    private static Integer CPU_SIZE = Runtime.getRuntime().availableProcessors();
    private static Integer coreSize = CPU_SIZE;
    private static Integer maxSize = (CPU_SIZE*2);

    /*****
    * @param: coreSize:核心线程数
    * @param: maxSize:最大线程数
    * @param: keepAliveTime:线程最大空闲时间
    * @param: unit:线程最大空闲时间的单位
    * @param: capacity:等待队列的线程容量
    * @param: threadName:线程名称
    * @methoName: createPoolExecutor
    * @return: java.util.concurrent.ThreadPoolExecutor
    * @date: 2022-06-09 14:18
    * @author: cs
    * @Description:线程池创建工具类
    */
    public static ThreadPoolExecutor createPoolExecutor(long keepAliveTime,
                                                        TimeUnit unit,
                                                        int capacity,
                                                        String threadName) {
        //配置等待队列的线程容量
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(capacity);
        //拒绝策略,这里超出的线程直接抛异常
        RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();
        //设置线程名称
        ThreadFactory factory = new ThreadFactory() {
            AtomicInteger at = new AtomicInteger(1);
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r,threadName+"->"+at.getAndIncrement());
            }
        };

        ThreadPoolExecutor executor = new ThreadPoolExecutor(coreSize, maxSize, keepAliveTime, unit, workQueue, factory, handler);
        return executor;
    }

    /*****
     * @param: coreSize:核心线程数
     * @param: maxSize:最大线程数
     * @param: keepAliveTime:线程最大空闲时间
     * @param: unit:线程最大空闲时间的单位
     * @param: capacity:等待队列的线程容量
     * @param: threadName:线程名称
     * @methoName: createPoolExecutor
     * @return: java.util.concurrent.ThreadPoolExecutor
     * @date: 2022-06-09 14:18
     * @author: cs
     * @Description:线程池创建工具类
     */
    public static ThreadPoolExecutor createPoolExecutor(int coreSize,
                                                        int maxSize,
                                                        long keepAliveTime,
                                                        TimeUnit unit,
                                                        int capacity,
                                                        String threadName) {
        //配置等待队列的线程容量
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(capacity);
        //拒绝策略,这里超出的线程直接抛异常
        RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();
        //设置线程名称
        ThreadFactory factory = new ThreadFactory() {
            AtomicInteger at=new AtomicInteger(1);
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r,threadName+"->"+at.getAndIncrement());
            }
        };

        ThreadPoolExecutor executor = new ThreadPoolExecutor(coreSize, maxSize, keepAliveTime, unit, workQueue, factory, handler);
        return executor;
    }

    public static void main(String[] args) {
        int cpuNum = Runtime.getRuntime().availableProcessors();
        System.out.println(cpuNum);
    }


}