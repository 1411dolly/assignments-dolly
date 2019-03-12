package com.example.SpringAssignment;
//Q1 Create a class Database with 2 instance variables port and name.
// Configure Database class bean in spring container through Spring XML.
// Initialize instance variables using setter method.
public class Database {
    private String name;
    private String port;

//    public Database(String name, String port) {
//        this.name = name;
//        this.port = port;
//    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
