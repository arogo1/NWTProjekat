// package com.example.microserviceuser.controller;

// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.client.RestTemplate;

// import com.example.microserviceuser.controller.exception.UserNotFoundException;
// import com.example.microserviceuser.models.User;
// import com.example.microserviceuser.models.error.ResourceNotFoundException;
// import com.example.microserviceuser.repository.UserRepository;
// import com.example.microserviceuser.service.IUserService;
// import com.example.microserviceuser.service.UserService;

// @RestController
// public class UserController {
	
// 	@Autowired
// 	private UserService userService;
	
// 	@Autowired
// 	private RestTemplate restTemplate;
	
// 	@GetMapping("/users")
// 	public Iterable<User>getUsers(){
//         return userService.findAllUsers();
//     }
	
//     @GetMapping("/user/{id}")
//     public User findById(@PathVariable("id") Integer id){
// 		return userService.findUserById(id).orElseThrow(() -> new ResourceNotFoundException("None of users found!"));	
//     }
    
//     @PostMapping("/user")
//     public void newUser(User newUser) {
//     	Iterable<User> allUsers = userService.findAllUsers();
// 		for (User usr : allUsers) {
// 			if(usr.getUsername().contentEquals(newUser.getUsername())) {
// 				throw new ResourceNotFoundException("Already exists user with this username");
// 			}
// 		}	
// 		userService.saveUser(newUser);
//     }

//     @DeleteMapping("/user/{id}")
//     public void deleteUser(@PathVariable Integer id) {
// 		userService.deleteUserById(id);
		
//     }
    
//     @PutMapping("/user/{id}")
//     public User updateUser(@RequestBody User newUser, @PathVariable("id") Integer id) {
//        return userService.updateUser(newUser, id);
//     }

// }
