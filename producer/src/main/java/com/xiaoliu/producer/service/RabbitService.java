package com.xiaoliu.producer.service;

import com.xiaoliu.rabbitmq.MQMessage;

public interface RabbitService {
    void sendDemo1Message(String message);

    /**
     * toptic模式的列队2
     * @param message
     */
    void sendDemo2Message(MQMessage message);

    /**
     * fanout广播模式的消息发送
     * @param message
     */
    void sendFanoutMessage(String message);
}
