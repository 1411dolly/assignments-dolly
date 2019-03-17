package com.spring.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Repository
public class UserDao3 {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Transactional(propagation = Propagation.NESTED)
    public void testNested2() {
        String sql = "INSERT INTO user (username,password,name,age,dob)VALUES(?,?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{"nested2", "abc12", "abc12", 20, new Date()});
        throw new RuntimeException();
    }
}
