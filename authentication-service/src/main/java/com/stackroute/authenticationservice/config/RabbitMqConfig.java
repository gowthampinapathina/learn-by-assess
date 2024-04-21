package com.stackroute.authenticationservice.config;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    @Value("${spring.rabbitmq.queue1}")
    private String queue;

    @Value("${spring.rabbitmq.exchange1}")
    private String exchange;

    @Value("${spring.rabbitmq.routingkey1}")
    private String routingKey;

    @Value("${spring.rabbitmq.username}")
    private String username;

    @Value("${spring.rabbitmq.password}")
    private String password;

    @Value("${spring.rabbitmq.host}")
    private String host;

    @Bean
    public Queue queue() {

        return new Queue(queue, true);
        //here queue is Queue name which we are getting from application.properties.
    }


    @Bean
    public Exchange myExchange() {

        //directExchange direct the message to a single Queue by matching of a RoutingKey.
        return ExchangeBuilder.directExchange(exchange).durable(true).build();

    }

    @Bean
    public Binding binding() {

        //binding is to connect queue and Exchange and then binding with the routingKey.
        return BindingBuilder.bind(queue()).to(myExchange()).with(routingKey).noargs();
    }

    @Bean
    ConnectionFactory connectionFactory() {
        //for stable connection we used
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(host);

        //setting Username and Password in cachingConnectionFactory class
        cachingConnectionFactory.setUsername(username);
        cachingConnectionFactory.setPassword(password);

        return cachingConnectionFactory;
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }
}
