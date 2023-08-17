package com.include.order.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author: chenshuo
 * @Date: 2023-02-03
 * @Time: 11:16
 * @version： 1.0
 * @Description:
 **/
@Component
@Slf4j
@RequiredArgsConstructor
public class CanalListener {
    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue(value = "canal.queue", durable = "true"),
                    exchange = @Exchange(value = "canal.exchange"),
                    key = "canal.routing.key"
            )
    })
    public void handleDataChange(Message content) {
        String body  = new String(content.getBody());
        log.info("Canal 监听内容：{}",body);
    }
}
