package com.project.api;


import com.project.Repo.UserRepository;
import com.project.User.UserInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api")
public class Controllers {
    private UserRepository userRepository;
    @PostMapping("/registering")
    public ResponseEntity<UserInfo> RegisterUser(@RequestBody UserInfo user){
        //save user details on database
        List<UserInfo> savedUser = userRepository.findByEmail(user.getEmail());

        //return saved user with http status ok
        return ResponseEntity.ok(user);

    }
}
