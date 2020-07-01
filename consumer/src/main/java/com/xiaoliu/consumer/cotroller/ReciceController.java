package com.xiaoliu.consumer.cotroller;

import com.rabbitmq.client.Channel;
import com.xiaoliu.rabbitmq.MQMessage;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Map;

@Component
public class ReciceController {
    private static int i=0;
    @RabbitListener(queues = "direct1.demo1")
    public void consumer(@Payload MQMessage message1 , Message message, @Headers Map<String,Object> headers, Channel channel)throws IOException{
        System.out.println("监听程序1开始执行"+message1.getMessage());
        if(i>7){
            System.out.println("重发");
            i++;
            i=i>10?5:i;
            //重发,不会丢失队列
            channel.basicNack((Long) headers.get(AmqpHeaders.DELIVERY_TAG),false,true);
        }else {
            System.out.println("已收到,消息出队列");
            //ack确认接收消息完毕
            i++;
            channel.basicAck((Long)headers.get(AmqpHeaders.DELIVERY_TAG),true);
        }

    }
}
