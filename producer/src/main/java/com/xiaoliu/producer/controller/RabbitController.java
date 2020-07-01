package com.xiaoliu.producer.controller;

import com.xiaoliu.producer.service.RabbitService;
import com.xiaoliu.producer.service.serviceimp.RabbitServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RabbitController {
    @Resource
    RabbitService rabbitService;
    @GetMapping("send")
    public String send(String name){
        System.out.println("name:"+name);
        try {
            rabbitService.sendDemo1Message(name);
            System.out.println("发送成功");
            return "发送成功";
        }catch (Exception e){
            return "发送失败";
        }
    }
}
