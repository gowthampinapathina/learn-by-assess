package com.stackroute.instructorservice.service;

import com.stackroute.instructorservice.exception.BatchAlreadyExistException;
import com.stackroute.instructorservice.model.Batch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqService implements RabbitListenerConfigurer {

        private InstructorService instructorService;
        private static final Logger logger = LoggerFactory.getLogger(RabbitMqService.class);

        @Autowired
        public RabbitMqService(InstructorService instructorService) {
                this.instructorService=instructorService;
        }

        @RabbitListener(queues = "${spring.rabbitmq.queue}")
        public void receivedMessage(Batch batch) {
                logger.info("Received batch details" + batch);
                try {
                        instructorService.createBatch(batch);
                }catch (BatchAlreadyExistException e){
                       System.err.println(e.getMessage());
                }
        }

        @Override
        public void configureRabbitListeners(RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar) {

        }
}
