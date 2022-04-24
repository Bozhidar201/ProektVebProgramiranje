package com.example.wp_project_original.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LogOutController {

    @GetMapping("/logout")
    String logOut(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/";
    }

}
