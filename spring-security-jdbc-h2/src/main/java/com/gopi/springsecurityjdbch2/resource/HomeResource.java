package com.gopi.springsecurityjdbch2.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

    @GetMapping("/")
    public String home() {
        return "<h1> It's Home Page </h1>";
    }

    @GetMapping("/user")
    public String user() {
        return "<h1> It's User Page </h1>";
    }

    @GetMapping("/admin")
    public String admin() {
        return "<h1> It's Admin Page </h1>";

    }

}
