//  package com.example.mikroservisquiz.Conroller;

//  import java.util.Optional;

//  import com.example.mikroservisquiz.models.DoneQuiz;
//  import com.example.mikroservisquiz.repository.doneQuizRepository;

//  import org.springframework.beans.factory.annotation.Autowired;
//  import org.springframework.web.bind.annotation.DeleteMapping;
//  import org.springframework.web.bind.annotation.GetMapping;
//  import org.springframework.web.bind.annotation.PathVariable;
//  import org.springframework.web.bind.annotation.PostMapping;
//  import org.springframework.web.bind.annotation.PutMapping;
//  import org.springframework.web.bind.annotation.RequestBody;
//  import org.springframework.web.bind.annotation.RestController;

//  @RestController
//  public class doneQuizController{

//      @Autowired
//      doneQuizRepository repo;

//      @GetMapping("/doneQuizes")
//      public Iterable<DoneQuiz>getQuizes(){
//          return repo.findAll();
//      }

//      @GetMapping("/doneQuiz/{id}")
//      public Optional<DoneQuiz> findById(@PathVariable("id") Integer id){
//          return repo.findById(id);
//      }

//      @PostMapping("/doneQuiz")
//      public DoneQuiz newQuiz(DoneQuiz newQuiz) {
//          return repo.save(newQuiz);
//      }
    
//      @DeleteMapping("/doneQuiz/{id}")
//      public void deleteQuiz(@PathVariable Integer id){ 
//          repo.deleteById(id); 
//      }

//      @PutMapping("/quiz/{id}")
//      public DoneQuiz updateDoneQuiz(@RequestBody DoneQuiz newData, @PathVariable("id") Integer id) {
//          return repo.findById(id)
//                      .map(quiz -> {
//                          quiz.setUserId(newData.getUserId());
//                      //System.out.println(quiz.toString());
//                      return repo.save(quiz);
//                  }).orElseGet(() -> repo.save(newData));
//      }
//  }