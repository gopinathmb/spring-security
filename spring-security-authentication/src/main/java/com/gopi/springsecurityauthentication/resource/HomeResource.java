package com.gopi.springsecurityauthentication.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

    @GetMapping("/")
    public String home()
    {
        return "<h1>Hello</h1>";
    }

    @GetMapping("/user")
    public String user()
    {
        return "This is from user";
    }

    @GetMapping("/admin")
    public String admin()
    {
        return "This is from Admin";
    }
}
