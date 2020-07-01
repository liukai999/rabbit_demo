package com.xiaoliu.rabbitmq;

import lombok.Data;

import java.io.Serializable;

/**
 * @author sy
 * Date: 2019/11/25 11:35
 * @Description MQ消息实体
 */
@Data
public class MQMessage implements Serializable {


    private static final long serialVersionUID = 4426149459382531256L;
    private Long messageId;
    private String message; //mq实体信息

}
