package com.example.wp_project_original.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KontaktController {

    @GetMapping("/contact")
    public String kontakt(){
        return "kontakt.html";
    }

}
