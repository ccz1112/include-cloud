package com.include.demo.design.chain;

/**
 * @projectName include-cloud-common
 * @packageName com.include.demo.design.chain
 * @className GatewayDao
 * @author： chenshuo
 * @version： 1.0
 * @since： 2023-08-16 15:42
 */
public interface GatewayDao {

    /**
     * 根据 handlerId 获取配置项
     * @param handlerId
     * @return
     */
    GatewayEntity getGatewayEntity(Integer handlerId);

    /**
     * 获取第一个处理者
     * @return
     */
    GatewayEntity getFirstGatewayEntity();

}
