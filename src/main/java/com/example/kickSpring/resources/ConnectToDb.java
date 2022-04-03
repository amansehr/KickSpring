package com.example.kickSpring.resources;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Map;

@RestController
@RequestMapping("/api/db")
@Repository
public class ConnectToDb {

    private static final String SQL_CREATE = "INSERT INTO u(username,password) VALUES(?,?)";
    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/")
    public Map<String,Object> solve(){
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,"Aman");
            ps.setString(2, BCrypt.hashpw("password",BCrypt.gensalt(10)));
            return ps;
        },keyHolder);

        return keyHolder.getKeys();
    }
}
