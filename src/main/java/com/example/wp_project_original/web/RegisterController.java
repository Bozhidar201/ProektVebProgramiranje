package com.example.wp_project_original.web;

import com.example.wp_project_original.model.enumerations.Role;
import com.example.wp_project_original.model.exceptions.InvalidArgumentException;
import com.example.wp_project_original.model.exceptions.PasswordsDoNotMatchException;
import com.example.wp_project_original.service.AuthService;
import com.example.wp_project_original.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {

    private final AuthService authService;
    private final UserService userService;

    public RegisterController(AuthService authService, UserService userService) {
        this.authService = authService;
        this.userService = userService;
    }

    @GetMapping("/register")
    public String getRegisterPage(){
        return "register.html";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String repeatPassword,
                           @RequestParam Role role,
                           Model model){

        try{
            this.userService.register(username,password,repeatPassword, role);
            return "redirect:/login";
        } catch (InvalidArgumentException | PasswordsDoNotMatchException ex){
            model.addAttribute("hasError", true);
            model.addAttribute("error", ex.getMessage());
            return "redirect:/register";
        }
    }

}
