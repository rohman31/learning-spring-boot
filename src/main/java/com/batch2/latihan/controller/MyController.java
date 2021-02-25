package com.batch2.latihan.controller;

import com.batch2.latihan.model.User;
import com.batch2.latihan.services.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/myApi")
public class MyController {

    @Autowired
    private UserRepository userRepo;

    @GetMapping("/hello")
    public String myFirst(){
        return "<h1> Hello World </h1>";
    }

    @GetMapping("/getUserById")
    public ResponseEntity<User> getUserById(@RequestParam(name = "userId") String id,
                                            @RequestParam String pagePerRow){
        System.out.println("============> PagePerRow: " +pagePerRow);
        User u = userRepo.findById(Integer.valueOf(id)).get();
        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    @PostMapping("/saveUserData")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        User u = userRepo.save(user);
        return new ResponseEntity<>(u, HttpStatus.CREATED);
    }
}
