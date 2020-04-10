package com.example.mikroservisquiz.servisi;

import java.util.Optional;

import com.example.mikroservisquiz.models.*;

public interface IDoneQuizService {
    public Iterable<DoneQuiz>getAllDneQuizes();
    public Optional<DoneQuiz> getDoneQuizById(Integer id);
    public void addDoneQuiz(DoneQuiz newDoneQuiz);
    public void deleteDoneQuiz(Integer id);
    public DoneQuiz editDoneQuiz(DoneQuiz newDoneQuiz,Integer id);

}