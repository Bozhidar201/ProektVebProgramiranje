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
public class LogInKorisnikController {

    private final UserService userService;
    private final AuthService authService;

    public LogInKorisnikController(UserService userService, AuthService authService) {
        this.userService = userService;
        this.authService = authService;
    }


    @GetMapping("/logInKorisnik")
    public String showLongInVraboten(){
        return "logInKorisnik.html";
    }

    @PostMapping("/logInKorisnik/Auth")
    public String logInKorisnik(@RequestParam String username,
                                @RequestParam String password,
                                HttpServletRequest request,
                                Model model){
        User user = null;
        try{
            user = this.authService.login(username,password);
            request.getSession().setAttribute("user", user);
            return "redirect:/mesechnaAgenda";
        } catch (InvalidUserCredentialsException ex){
            model.addAttribute("hasError", true);
            model.addAttribute("error", ex.getMessage());
            return "logInKorisnik.html";
        }
    }
}
