/*
package com.example.mikroservisquiz.Configuration;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class Producer {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${rabbitmq.queue}")
    String queueName;

    @Value("${rabbitmq.exchange}")
    String exchange;

    @Value("${rabbitmq.routingKey}")
    private String routingKey;

    public void send(Integer id) {
        rabbitTemplate.convertAndSend(exchange, routingKey, id);
        System.out.println("Send msg = " + id);

    }
}
*/
