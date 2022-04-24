package com.example.wp_project_original.web;

import com.example.wp_project_original.model.User;
import com.example.wp_project_original.model.exceptions.InvalidUserCredentialsException;
import com.example.wp_project_original.service.AuthService;
import com.example.wp_project_original.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LogInVraboteniController {
    private final UserService userService;
    private final AuthService authService;

    public LogInVraboteniController(UserService userService, AuthService authService) {
        this.userService = userService;
        this.authService = authService;
    }

    @GetMapping("/logInVraboten")
    public String showLongInVraboten(){

        return "logInVraboten.html";
    }

    @PostMapping("/logInVraboteni/Auth")
    public String logInVraboteni(HttpServletRequest request,
                                 Model model){
        User user = null;
        try{
            user = this.authService.login(request.getParameter("username"),request.getParameter("password"));
            request.getSession().setAttribute("user", user);
            return "redirect:/bills";
        } catch (InvalidUserCredentialsException exception){
            model.addAttribute("hasError", true);
            model.addAttribute("error", exception.getMessage());
            return "logInVraboten.html";
        }

    }

}
