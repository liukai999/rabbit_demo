package com.xiaoliu.producer.service.serviceimp;

import com.xiaoliu.producer.service.RabbitService;
import com.xiaoliu.rabbitmq.Constants;
import com.xiaoliu.rabbitmq.MQMessage;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import utils.IdUtils;

import javax.annotation.Resource;

@Service
public class RabbitServiceImpl implements RabbitService {
    @Resource
    private RabbitTemplate rabbitTemplate;
    @Override
    public void sendDemo1Message(String message) {
        MQMessage mqMessage = new MQMessage();
        mqMessage.setMessage(message+new IdUtils().nextId());
        send(Constants.SY_TOPIC,Constants.DIRECT_DEMO1_QUEUE,mqMessage);
    }

    @Override
    public void sendDemo2Message(MQMessage message) {

    }

    @Override
    public void sendFanoutMessage(String message) {

    }
    public void send(String exchange,String routingKey,MQMessage message){
        //设置消息id，也可以用rabbit自带的，但这里我使用自己定义的消息id
        long id= new IdUtils().nextId();
        message.setMessageId(id);
        CorrelationData correlationData = new CorrelationData(id+"");
        //最终还是调用convertAndsend方法  交换机 路由key
        rabbitTemplate.convertAndSend(exchange,routingKey,message,correlationData);
    }
}
