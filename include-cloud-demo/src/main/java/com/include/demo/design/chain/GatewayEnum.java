package com.include.demo.design.chain;

/**
 * @projectName include-cloud-common
 * @packageName com.include.demo.design.chain
 * @className GatewayEnum
 * @author： chenshuo
 * @version： 1.0
 * @since： 2023-08-16 15:39
 */
public enum GatewayEnum {

    // handlerId, 拦截者名称，全限定类名，preHandlerId，nextHandlerId
    API_HANDLER(new GatewayEntity(1, "api接口限流", "com.include.demo.design.chain.ApiLimitGatewayHandler", null, 2)),
    BLACKLIST_HANDLER(new GatewayEntity(2, "黑名单拦截", "com.include.demo.design.chain.BlacklistGatewayHandler", 1, 3)),
    SESSION_HANDLER(new GatewayEntity(3, "用户会话拦截", "com.include.demo.design.chain.SessionGatewayHandler", 2, null)),
    ;

    GatewayEntity gatewayEntity;

    public GatewayEntity getGatewayEntity() {
        return gatewayEntity;
    }

    GatewayEnum(GatewayEntity gatewayEntity) {
        this.gatewayEntity = gatewayEntity;
    }

}

