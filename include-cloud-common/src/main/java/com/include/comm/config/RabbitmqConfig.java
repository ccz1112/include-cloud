package com.include.comm.config;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.RetryPolicy;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

import java.util.Collections;

@Slf4j
@Setter
@EnableRabbit
@Configuration
@ConfigurationProperties(prefix = "spring.rabbitmq")
public class RabbitmqConfig {

    private String host;
    private Integer port;
    private String username;
    private String password;
    private String virtualHost;

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory factory = new CachingConnectionFactory();
        factory.setHost(host);
        factory.setPort(port);
        factory.setUsername(username);
        factory.setPassword(password);
        factory.setVirtualHost(virtualHost);


        factory.setPublisherReturns(true);
        // 5s 心跳
        factory.setRequestedHeartBeat(5);
        // 建立连接超时时间 1s
        factory.setConnectionTimeout(1000);
        factory.setCacheMode(CachingConnectionFactory.CacheMode.CHANNEL);
        // 设置每个Connection中缓存Channel的数量
        // 当Channel数量大于缓存数量时 多出来没法放进缓存的会被关闭
        factory.setChannelCacheSize(10);
        // 单位：毫秒；配合channelCacheSize不仅是缓存数量，而且是最大的数量。
        //  从缓存获取不到可用的Channel时，不会创建新的Channel，会等待这个值设置的毫秒数
        // 同时，在CONNECTION模式，这个值也会影响获取Connection的等待时间，
        //  超时获取不到Connection也会抛出AmqpTimeoutException异常。
        factory.setChannelCheckoutTimeout(1000);
        return factory;
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        // 生产者和消费者使用不同的Connection
        template.setUsePublisherConnection(true);
        // 将mandatory属性设为true（ReturnCallback需要，ConfirmCallback不需要）
        template.setMandatory(true);
        template.setMessageConverter(new Jackson2JsonMessageConverter());
        template.setCorrelationDataPostProcessor((message, correlationData) -> {
            message.getMessageProperties().setCorrelationId(correlationData.getId());
            return correlationData;
        });
        // 每一条发出的消息都会调用ConfirmCallback
        template.setConfirmCallback((correlationData, ack, cause) -> {
            if (null != correlationData) {
              //  MDC.put(BaseConstants.MSG_ID, correlationData.getId());
            }
            if (ack) {
                log.info("消息发送至exchange成功");
            } else {
                log.error("消息发送至exchange失败, cause = {}", cause);
            }
           // MDC.remove(BaseConstants.MSG_ID);
        });
        // 只有在消息进入exchange但没有进入queue时才会调用
        template.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> {
            log.error("exchange = {}, routingKey = {}", exchange, routingKey);
            log.error("code = {}, key = {}", replyCode, replyText);
            log.error("data = {}", message);
        });
        return template;
    }

    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setConcurrentConsumers(1);
        factory.setMaxConcurrentConsumers(10);
        factory.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        factory.setMessageConverter(new Jackson2JsonMessageConverter());
        // 设置每次请求发送给每个Consumer的消息数量
        factory.setPrefetchCount(1);
        factory.setErrorHandler(t -> log.error("mq consumer error cause = ", t));
        FixedBackOffPolicy backOffPolicy = new FixedBackOffPolicy();
        // 间隔 10 分钟 600000
        backOffPolicy.setBackOffPeriod(600000);
        // 重试 1 次 指定异常
        //RetryPolicy retryPolicy = new SimpleRetryPolicy(3, Collections.singletonMap(NeedRequeueException.class, true));
        RetryPolicy retryPolicy = new SimpleRetryPolicy(3);

        // 默认 重试3次 Exception.class 触发
        RetryTemplate template = new RetryTemplate();
        template.setBackOffPolicy(backOffPolicy);
        template.setRetryPolicy(retryPolicy);
        factory.setRetryTemplate(template);
        return factory;
    }


}
