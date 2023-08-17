package com.include.comm.util;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import reactor.core.publisher.Mono;

/**
 * @author: chenshuo
 * @Date: 2023-05-16
 * @Time: 14:53
 * @version： 1.0
 * @Description:
 **/
@Component
public class TransactionUtils {

    public static void doAfterTransaction(TransactionCompletion transactionCompletion){
        if(TransactionSynchronizationManager.isActualTransactionActive()){
            TransactionSynchronizationManager.registerSynchronization(transactionCompletion);
        }
    }

    @Transactional
    public void doTx(){
        //此demo为事务提交后,才执行的回调,例如
        /**
         * 1.数据库操作代码1
         * 2.数据库操作代码2
         * 3.mq发消息代码
         * 4.其它代码
         * 第四行发生异常,则事务回滚,MQ就不会发送
         * **/
        TransactionUtils.doAfterTransaction(new TransactionCompletion(()->{
            //事务执行成功回调 MQ发送
        }));
    }
}



class TransactionCompletion implements TransactionSynchronization{

    private Runnable runnable;

    public TransactionCompletion(Runnable runnable) {
        this.runnable = runnable;
    }

    @Override
    public void afterCompletion(int status) {
        if(status == TransactionSynchronization.STATUS_COMMITTED){
            this.runnable.run();
        }
    }
}