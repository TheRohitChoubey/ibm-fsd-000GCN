package com.example.demo.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ProjectIdRequestModel;

@Service
public class RabbitMqService {
    @Autowired
    private AmqpTemplate amqpTemplate;

    private String EXCHANGE="otp-exchange";

    private String ROUTING_KEY="projectDetail";

    public void sendMessage(ProjectIdRequestModel projectDetail) {
        amqpTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, projectDetail);
    }
}
