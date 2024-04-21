package com.stackroute.adminservice.services;

import com.stackroute.adminservice.model.Batch;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqSender {
        private RabbitTemplate rabbitTemplate;

        @Autowired
        public RabbitMqSender(RabbitTemplate rabbitTemplate) {
                this.rabbitTemplate= rabbitTemplate;
        }

        @Value("${spring.rabbitmq.exchange}")
        private String exchange;

        @Value("${spring.rabbitmq.routingkey}")
        private String routingkey;
        public void send(Batch batch) {
                System.out.println("Batch details to be sent:"+batch);
                rabbitTemplate.convertAndSend(exchange,routingkey,batch);
        }


}
