package com.example.mikroservisquiz.servisi;

import java.util.ArrayList;
import java.util.List;

import com.example.mikroservisquiz.models.DoneQuiz;
import com.example.mikroservisquiz.repository.doneQuizRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class doneQuiyService {
    @Autowired
    doneQuizRepository repository;

    // @Autowired
    // doneQuizDAO doneQuizdao;

    public List<DoneQuiz>getAllDoneQuizes(){
        return repository.findAll();
    }

    public DoneQuiz getDoneQuizById(int id){
        return repository.findById(id).get();
    }

    // Pošto jedan user može raditi više kvizova, na osnovu id-a user-a trebalo bi da se vrati lista svih kvizova koje je uradio
    public List<DoneQuiz> getdoneQuizByUserId(int userId){
        List<DoneQuiz> doneQuizes = new ArrayList<DoneQuiz>();
        //Iterable<DoneQuiz> response = repository.findByUserId(userId);
        //response.forEach(doneQuizes::add);
        return doneQuizes;
    }
    
    //get završeni kviz na osnovu kviza koje je radio
    // public DoneQuiz getdoneQuizByQuizId(int quizId){
    //     return repository.findById(id)
    // }

    public void addDoneQuiz(DoneQuiz newDoneQuiz){
        repository.save(newDoneQuiz);
    }

    public void deleteDoneQuiz(int id){
        repository.deleteById(id);
    }

    // public DoneQuiz editDoneQuiz(DoneQuiz newDoneQuiz,int id){
    //     return repository.findById(id).map(
    //         quiz->{
    //             quiz.setQuizId(newDoneQuiz.getQuizId());
    //             quiz.setUserId(newDoneQuiz.getUserId());
    //             return repository.save(quiz);
    //         }).orElseGet(()-> repository.save(newDoneQuiz));
    // }
}