package com.stackroute.learnerservice.service;

import com.stackroute.learnerservice.model.Learner;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqLearnerService {

    private RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitMqLearnerService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${spring.rabbitmq.exchange1}")
    private String exchange;

    @Value("${spring.rabbitmq.routingkey1}")
    private String routingkey;

    public void send(Learner learner) {
        rabbitTemplate.convertAndSend(exchange,routingkey,learner);
    }
}
