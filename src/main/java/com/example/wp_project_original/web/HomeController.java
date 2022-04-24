package com.example.wp_project_original.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    String home(){
        return "home.html";
    }

    @GetMapping("/access_denied")
    public String accessDeniedPage(){
        return "access_denied.html";
    }
}
