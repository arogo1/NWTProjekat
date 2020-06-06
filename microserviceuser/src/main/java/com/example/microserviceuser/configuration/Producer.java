package com.example.microserviceuser.configuration;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class Producer {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${javainuse.rabbitmq.exchange}")
    private String exchange;

    @Value("${javainuse.rabbitmq.routingkey}")
    private String routingkey;

    public void send(Integer id) {
        rabbitTemplate.convertAndSend(exchange, routingkey, id);
        System.out.println("Send msg = " + id);

    }
}
