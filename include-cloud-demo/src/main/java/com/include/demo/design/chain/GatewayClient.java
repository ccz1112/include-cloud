package com.include.demo.design.chain;

/**
 * @author: chenshuo
 * @Date: 2023-08-16
 * @Time: 15:45
 * @version： 1.0
 * @Description:
 **/
public class GatewayClient {

    public static void main(String[] args) {
        GatewayHandler firstGetewayHandler = GatewayHandlerEnumFactory.getFirstGatewayHandler();
        firstGetewayHandler.handler();
    }

}