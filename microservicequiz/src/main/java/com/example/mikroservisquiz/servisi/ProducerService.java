package com.example.mikroservisquiz.servisi;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${rmq.exchange}")
    String exchange;

    @Value("${rmq.routingKey}")
    private String routingKey;

    public void send(Integer userId) {
        rabbitTemplate.convertAndSend(exchange, routingKey, userId.toString());
        System.out.println("Message sent with userId = " + userId);
    }
}