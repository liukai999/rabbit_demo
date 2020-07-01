package com.xiaoliu.producer.rabbit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RabbitReturnCallback implements RabbitTemplate.ReturnCallback {
    @Override
    public void returnedMessage(Message message, int i, String s, String s1, String s2) {
        log.info("----------消息从交换器推送到队列失败---------");
        log.info("消息主体",message);
        log.info("回复编码",i);
        log.info("回复编码",i);

    }
}
