package com.deniron.DenironCRUD.controller;

import com.deniron.DenironCRUD.exception.ResourceNotFoundException;
import com.deniron.DenironCRUD.model.User;
import com.deniron.DenironCRUD.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

   // build create user REST API
   @PostMapping
   public User createUser(@RequestBody User user) {
       return userRepository.save(user);
   }

   // build get user by id REST API
   @GetMapping("{id}")
   public ResponseEntity<User> getUserById(@PathVariable String id){
       User user = userRepository.findById(id)
               .orElseThrow(() -> new ResourceNotFoundException("User not exist with id:" + id));
       return ResponseEntity.ok(user);
   }

   // build update user REST API
   @PutMapping("{id}")
   public ResponseEntity<User> updateUser(@PathVariable String id,@RequestBody User userDetails) {
       User updateUser = userRepository.findById(id)
               .orElseThrow(() -> new ResourceNotFoundException("User not exist with id: " + id));

       updateUser.setUsername(userDetails.getUsername());
       updateUser.setPassword(userDetails.getPassword());
       updateUser.setEmail(userDetails.getEmail());

       userRepository.save(updateUser);

       return ResponseEntity.ok(updateUser);
   }

   // build delete user REST API
   @DeleteMapping("{id}")
   public ResponseEntity<HttpStatus> deleteUser(@PathVariable String id){

       User user = userRepository.findById(id)
               .orElseThrow(() -> new ResourceNotFoundException("User not exist with id: " + id));

       userRepository.delete(user);

       return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }


}
