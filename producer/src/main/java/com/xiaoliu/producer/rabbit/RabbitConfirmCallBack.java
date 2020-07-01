package com.xiaoliu.producer.rabbit;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class RabbitConfirmCallBack implements RabbitTemplate.ConfirmCallback {

    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
            System.out.println("发送的消息为:"+correlationData.getId());
        if(b){
            System.out.println("消息推送到交换器成功");
        }else{
            System.out.println("消息推送到交换器失败");
            // 失败原因
            System.out.println("失败的原因：" + s);
        }
    }
}
