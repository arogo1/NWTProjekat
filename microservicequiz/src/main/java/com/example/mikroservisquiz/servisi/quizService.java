package com.example.mikroservisquiz.servisi;

import java.util.List;

import com.example.mikroservisquiz.models.Quiz;
import com.example.mikroservisquiz.repository.quizRepository;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class quizService {
   
    @Autowired
    private quizRepository repository;
    @Autowired
    private AmqpTemplate rabbitTemplate;

   /* @Value("${javainuse.rabbitmq.exchange}")
    private String exchange;

    @Value("${javainuse.rabbitmq.routingkey}")
    private String routingkey;*/

    public List<Quiz> getAllQuizes(){
        return repository.findAll();
    }

    public Quiz getById(int id){
        return repository.findById(id);
    }

   /* public void addQuiz(Quiz quiz){
        rabbitTemplate.convertAndSend(exchange, routingkey, quiz);
        System.out.println("Send msg = " + quiz);
        repository.save(quiz);
    }*/

    public void deleteQuiz(int id){
        repository.deleteById(id);
    }
}
