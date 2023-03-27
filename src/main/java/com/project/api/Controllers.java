package com.project.api;


import com.project.Repo.UserRepository;
import com.project.User.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
@RequestMapping("/api")
public class Controllers {
    @Autowired
    private UserRepository userRepository;
    @PostMapping("/registering")
    public ResponseEntity<UserInfo> RegisterUser(@RequestBody UserInfo user){
        //save user details on database
        UserInfo savingUser = userRepository.findByEmail(user.getEmail());
        if(savingUser != null){
            System.out.println("user exists");
        }else {
            userRepository.save(user);
        }
        //return saved user with http status ok
        return new ResponseEntity<>(savingUser, HttpStatus.CREATED);

    }
}
