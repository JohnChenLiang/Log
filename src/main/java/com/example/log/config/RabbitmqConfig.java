package com.example.log.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {

    @Bean
    public Queue logTestQueue() {
        //参数分别是 队列名称，durable-是否持久化，exclusive-是否排他的队列，autoDelete-是否自动删除，arguments-队列中的消息什么时候会自动被删除 （设置死信交换器和死信队列等设置）
        //持久化、不排他，不自动删除的队列
        return new Queue("log.test.queue", true, false, false, null);
    }

    // 配置Routing（路由模式）的direct交换机。
    @Bean
    DirectExchange logTestExchange() {
        //参数分别是 交换机名称，durable-是否持久化，autoDelete-是否自动删除，
        //持久化、不自动删除的交换机
        return new DirectExchange("log.test.exchange", true, false);
    }

    //direct交换机绑定队列 还有 routingKey
    @Bean
    Binding logTestBinding() {
        return BindingBuilder.bind(logTestQueue()).to(logTestExchange()).with("log.test.routing.key");
    }


}
