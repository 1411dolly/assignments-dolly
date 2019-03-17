package com.spring.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Repository
public class UserDao2 {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    UserDao3 userDao3;

    @Transactional(propagation = Propagation.REQUIRED)
    public void testRequired() {
        String sql = "INSERT INTO user (username,password,name,age,dob)VALUES(?,?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{"required_child", "abc", "abc", 10, new Date()});
        throw new RuntimeException("Rollback this (Required)Transaction!!!");
    }


    @Transactional(propagation=Propagation.REQUIRES_NEW)
    public void testRequiresNew() {
        String sql = "INSERT INTO user (username,password,name,age,dob)VALUES(?,?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{"required_new_child", "abc", "abc", 11, new Date()});
        throw new RuntimeException("Rollback this(Required New) transaction!");
    }

    @Transactional(propagation=Propagation.MANDATORY)
    public void testMandatory() {
        String sql = "INSERT INTO user (username,password,name,age,dob)VALUES(?,?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{"mandatory_child", "abc", "abc", 12, new Date()});
        throw new RuntimeException("Rollback this(Mandatory) transaction!");
    }

    @Transactional(propagation=Propagation.NESTED)
    public void testNested() {
        String sql = "INSERT INTO user (username,password,name,age,dob)VALUES(?,?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{"nested_child", "abc", "abc", 13, new Date()});
        try{
        userDao3.testNested2();}
        catch (Exception e){
            System.out.println("you can catch exception when nested transaction fails" +
                    "\n but can still commit the whole transaction for valid ones");
        }
    }

    @Transactional(propagation=Propagation.NEVER)
    public void testNever() {
        String sql = "INSERT INTO user (username,password,name,age,dob)VALUES(?,?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{"never_child", "abc", "abc", 14, new Date()});
        throw new RuntimeException("Rollback this(Never) transaction!");
    }

    @Transactional(propagation=Propagation.NOT_SUPPORTED)
    public void testNotSupported() {
        String sql = "INSERT INTO user (username,password,name,age,dob)VALUES(?,?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{"notSupported_child", "abc", "abc", 15, new Date()});
        throw new RuntimeException("Rollback this(Never) transaction!");
    }

    @Transactional(propagation=Propagation.SUPPORTS)
    public void testSupported() {
        String sql = "INSERT INTO user (username,password,name,age,dob)VALUES(?,?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{"notSupported_child", "abc", "abc", 15, new Date()});
        throw new RuntimeException("Rollback this(Never) transaction!");
    }
}