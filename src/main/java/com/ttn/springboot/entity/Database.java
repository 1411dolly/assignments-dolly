package com.ttn.springboot.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Database {
//Q4    Create a Bean Database with two fields port and name and Access its values using application.properties (1 Mark)
    @Value("${app.port}")
    private Integer port;

    @Value("${app.name}")
    private String name;

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Database{" +
                "port=" + port +
                ", name='" + name + '\'' +
                '}';
    }
}
