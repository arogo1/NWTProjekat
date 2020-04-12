package com.example.microserviceinquiry.DAO;

import com.example.microserviceinquiry.Models.Answer;

import org.springframework.data.repository.CrudRepository;

public interface AnswerRepository extends CrudRepository<Answer, Integer> {
    // @Query("SELECT a FROM answer a WHERW a.question_id = :questionId")
    // Iterable<Answer> getAnswerByQuestionId(@Param("questionId") int questionId);
}