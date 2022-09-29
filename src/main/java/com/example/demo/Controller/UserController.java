package com.example.demo.Controller;

import com.example.demo.Model.User;
import com.example.demo.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String test(){
        return "Funcionou!";
    }

    @PostMapping("/create")
    public ResponseEntity<User> create(@RequestBody User user){
        User created = userService.create(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
}
