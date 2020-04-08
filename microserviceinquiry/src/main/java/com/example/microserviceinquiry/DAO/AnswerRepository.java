package com.example.microserviceinquiry.DAO;

import java.util.List;

import com.example.microserviceinquiry.Models.Answer;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AnswerRepository extends CrudRepository<Answer, Integer> {
    // @Query("SELECT a FROM answer a WHERW a.question_id = :questionId")
    // Iterable<Answer> getAnswerByQuestionId(@Param("questionId") int questionId);
}