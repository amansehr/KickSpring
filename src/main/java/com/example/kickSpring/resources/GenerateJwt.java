package com.example.kickSpring.resources;

import com.example.kickSpring.Constants;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/jwt")

public class GenerateJwt {

    private String generateToken(){
        USERNAME username = new USERNAME();
        username.setName("Aman");
        long timestamp = System.currentTimeMillis();
        String token = Jwts
                .builder()
                .signWith(SignatureAlgorithm.HS256, Constants.API_SECRET_KEY)
                .setIssuedAt(new Date(timestamp))
                .setExpiration(new Date(timestamp + Constants.EXPIRE))
                .claim("userId","1")
                .claim("username",username.getName())
                .compact();
        return token;
    }
    @GetMapping("/")
    public ResponseEntity<Map<String,String>> solve(){
        Map<String,String> mp = new HashMap<>();
        mp.put("token",generateToken());
        return new ResponseEntity<>(mp, HttpStatus.OK);
    }
}
