package com.include.demo.design.chain;

/**
 * @author: chenshuo
 * @Date: 2023-08-16
 * @Time: 15:44
 * @version： 1.0
 * @Description:
 **/
public abstract class GatewayHandler {
    /**
     * 下一关用当前抽象类来接收
     */
    protected GatewayHandler next;

    public void setNext(GatewayHandler next) {
        this.next = next;
    }

    public abstract void handler();
}