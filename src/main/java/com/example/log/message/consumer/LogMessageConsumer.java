package com.example.log.message.consumer;

import com.example.log.pojo.Log;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class LogMessageConsumer {

    //接收对象。@RabbitListener 标注在方法上，是指定某方法作为消息消费的方法，直接监听指定的队列，此时接收的参数需要与发送的类型一致。
    @RabbitListener(queues = "log.test.queue")
    public void LogMessageConsumer(Log log){
        System.out.println("收到消息" + log.toString());
    }
}
