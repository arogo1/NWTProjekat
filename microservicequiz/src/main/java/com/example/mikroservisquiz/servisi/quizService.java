package com.example.mikroservisquiz.servisi;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class quizService {
    @PersistenceContext
    private EntityManager entityManager;

    // public int insert(Quiz quiz) {
    //     entityManager.persist(quiz);
    //     return quiz.getId();
    // }

}
