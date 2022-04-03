package com.example.kickSpring.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class User {
    @PostMapping("/register")
    public ResponseEntity<Map<String,String>> regsiterUser(@RequestBody Map<String,Object> userMap){
        String username = (String) userMap.get("FirstName");
        String Password = (String) userMap.get("Password");
        Map<String ,String> mp = new HashMap<>();

        mp.put("Message" , username);
        return new ResponseEntity<>(mp, HttpStatus.OK);
    }

    @GetMapping("/register")
    public String registerUser(){
        return "Hii";
    }
}
