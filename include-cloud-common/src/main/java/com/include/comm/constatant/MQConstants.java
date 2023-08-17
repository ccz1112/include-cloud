package com.include.comm.constatant;

/**
 * @projectName include-cloud-common
 * @packageName com.include.comm.constatant
 * @className ColumnConstant
 * @author： chenshuo
 * @version： 1.0
 * @since： 2022-11-23 17:39
 */
public interface MQConstants {

    /**队列**/
    interface QUEUE{
        String ORDER_QUEUE = "";
    }
    /**交换机**/
    interface EXCHANGE{
        String ORDER_EXCHANGE = "";
    }

    /**路由KEY**/
    interface ROUTE_KEY{
        String ORDER_ROUTE = "";
    }

}
