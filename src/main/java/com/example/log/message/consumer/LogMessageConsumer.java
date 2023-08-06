package com.example.log.message.consumer;

import com.alibaba.fastjson.JSON;
import com.example.log.pojo.Log;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class LogMessageConsumer {

//    //对应第一个convertAndSend
//    //接没有持久化的消息，参数是 对象。
//    // 因为配置 application.properties(不是RabbitmqConfig)，设置了手动ack，代码里没ack，所以队列里的消息都是unack的状态。
//    //接收对象。@RabbitListener 标注在方法上，是指定某方法作为消息消费的方法，直接监听指定的队列，此时接收的参数需要与发送的类型一致。
//    @RabbitListener(queues = "log.test.queue")
//    public void LogMessageConsumer(Log log){
//        System.out.println("收到消息" + log.toString());
//        System.out.println("把log存到数据库里。");
//    }

    //对应第二个convertAndSend
    //接持久化的消息，然后 手动ack确认。参数是 对象、message、channel
    @RabbitListener(queues = "log.test.queue")
    public void LogMessageConsumer(Log log, Message message, Channel  channel) throws IOException {
        System.out.println("收到消息，单独的对象" + log.toString());
        System.out.println("把log存到数据库里。");
        //手动ack确认。确认处理完消息。
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
        System.out.println("手动ack确认完");
    }

//    //对应第三个convertAndSend
//    //接持久化的消息，然后 手动ack确认。参数是 message、channel，然后具体的对象在message里。
//    @RabbitListener(queues = "log.test.queue")
//    public void LogMessageConsumer(Message message, Channel channel) throws IOException {
//        Log log = JSON.parseObject(new String(message.getBody()), Log.class);
//        System.out.println("收到消息，包含在message里的" + log.toString());
//        System.out.println("把log存到数据库里。");
//        //手动ack确认。确认处理完消息。
//        channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
//        System.out.println("手动ack确认完");
//    }


}
