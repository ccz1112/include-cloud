package com.include.demo.design.chain;

/**
 * @author: chenshuo
 * @Date: 2023-08-16
 * @Time: 16:27
 * @version： 1.0
 * @Description:
 **/
public class SessionGatewayHandler extends GatewayHandler{

    @Override
    public void handler() {
        System.out.println("第三步，用户会话拦截校验");
        if(this.next != null){
            this.next.handler();
        }
    }
}