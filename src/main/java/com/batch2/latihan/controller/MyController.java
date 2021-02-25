package com.batch2.latihan.controller;

import com.batch2.latihan.model.CustomMappingModel;
import com.batch2.latihan.model.User;
import com.batch2.latihan.services.CustomQueryDAO;
import com.batch2.latihan.services.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/myApi")
public class MyController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private CustomQueryDAO ccDao;

    @GetMapping("/hello")
    public String myFirst(){
        return "<h1> Hello World </h1>";
    }

    @GetMapping("/getUserById")
    public ResponseEntity<User> getUserById(@RequestParam(name = "userId") String id){

        User u = userRepo.findById(Integer.valueOf(id)).get();
        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    @PostMapping("/getByEmailAndName")
    public ResponseEntity<List<User>> getByEmailAndUsername(@RequestParam String email,
                                                            @RequestParam String username
    ){
        List<User> list = userRepo.findByEmailAndUserName(email, username);
        return ResponseEntity.ok(list);
    }

    @PostMapping("/saveUserData")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        User u = userRepo.save(user);
        return new ResponseEntity<>(u, HttpStatus.CREATED);
    }

    @GetMapping("/nativeQuery")
    public ResponseEntity<List<CustomMappingModel>> getNativeQuery(@RequestParam String userName){
        List<CustomMappingModel> list = ccDao.getCustomQueryNative(userName);
        return ResponseEntity.ok(list);
    }

}
