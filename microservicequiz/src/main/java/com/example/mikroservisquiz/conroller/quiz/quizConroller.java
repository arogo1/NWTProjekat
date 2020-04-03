// package com.example.mikroservisquiz.conroller.quiz;


// import com.example.mikroservisquiz.conroller.quiz.exception.quizNotFoundException;
// import com.example.mikroservisquiz.models.Quiz;
// import com.example.mikroservisquiz.servisi.quizService;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RestController;

// @RestController
// public class quizConroller{

//     @Autowired
//     private quizService service;

//     @GetMapping("/quizes")
//     public Iterable<Quiz>getQuizes(){
//         return service.getAllQuizes();
//     }

//     @GetMapping("/quiz/{id}")
//     public Quiz findById(@PathVariable("id") Integer id){
//         return service.getById(id).orElseThrow(() -> new quizNotFoundException(id));
//     }

//     @PostMapping("/quiz")
//     public void newQuiz(Quiz newQuiz) {
//          service.addQuiz(newQuiz);
//     }
    
//     @DeleteMapping("/quiz/{id}")
//     public void deleteQuiz(@PathVariable Integer id) { 
//         service.deleteQuiz(id);
//     }

//     @PutMapping("/quiz/{id}")
//     public Quiz updateQuiz(@RequestBody Quiz newquiz, @PathVariable("id") Integer id) {
//         return service.editQuiz(newquiz, id);
//     }
// }