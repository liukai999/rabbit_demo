package com.xiaoliu.consumer;

import com.xiaoliu.rabbitmq.MQMessage;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitTemplateConfigurer;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConsumerApplicationTests {
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Test
    void contextLoads() {
        System.out.println("程序执行了");
        MQMessage o = (MQMessage) rabbitTemplate.receiveAndConvert("direct1.demo1");
        System.out.println(o);
    }

}
