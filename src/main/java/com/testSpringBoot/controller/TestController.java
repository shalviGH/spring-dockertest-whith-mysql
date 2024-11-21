package com.testSpringBoot.controller;

import com.testSpringBoot.UserDTO;
import com.testSpringBoot.UserEntity;
import com.testSpringBoot.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/test")
public class TestController {

    @Autowired
    UserService userService;

    @GetMapping("/test")
    public String test(){
        String message = "Probando endpoint";

        return message;
    }

    @GetMapping("/getName/{name}")
    public String getName(@PathVariable String name){
        String gretings = "Hola me llamo " + name;

        return gretings;
    }

    @PostMapping("/create")
    public ResponseEntity<UserEntity> create(@RequestBody UserDTO userDTO){
        UserEntity user = userService.create(userDTO);

        return new ResponseEntity<UserEntity>(user, HttpStatusCode.valueOf(201));
    }

    @GetMapping("/list")
    public ResponseEntity<List<UserEntity>>  list(){

        List<UserEntity> list = userService.findAll();

        return new ResponseEntity<List<UserEntity>> (list, HttpStatusCode.valueOf(200));


    }
}
