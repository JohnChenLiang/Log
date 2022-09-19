package com.example.log.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {

    @Bean
    public Queue logTestQueue() {
        return new Queue("log.test.queue");
    }

    // 配置Routing（路由模式）的direct交换机。
    @Bean
    DirectExchange logTestExchange() {
        return new DirectExchange("log.test.exchange");
    }

    //direct交换机绑定队列 还有 routingKey
    @Bean
    Binding logTestBinding() {
        return BindingBuilder.bind(logTestQueue()).to(logTestExchange()).with("log.test.routing.key");
    }


}
