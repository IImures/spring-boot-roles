package com.example.sec.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class MyController {

    @GetMapping(path = "/")
    public String home(){
        return "<h1>Spring is Here</h1>";
    }

    @GetMapping(path = "/user")
    public String welcomeUser(){
        return "<h1>Welcome User</h1>" +
                "<a herf = \"http://localhost:8080/logout\">Logout</a>";
    }

    @GetMapping(path = "/admin")
    public String welcomeAdmin(){
        return "<h1>Welcome Admin</h1>" +
                "<a herf = \"http://localhost:8080/logout\">Logout</a>";
    }
}
