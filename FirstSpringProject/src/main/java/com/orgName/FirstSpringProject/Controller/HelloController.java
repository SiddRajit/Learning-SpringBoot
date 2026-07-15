package com.orgName.FirstSpringProject.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String sayHello () {
        return "Hi, Welcome to First Spring project";
    }
}
