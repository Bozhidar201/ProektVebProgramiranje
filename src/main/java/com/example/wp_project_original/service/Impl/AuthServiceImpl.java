package com.example.wp_project_original.service.Impl;

import com.example.wp_project_original.model.User;
import com.example.wp_project_original.model.enumerations.Role;
import com.example.wp_project_original.model.exceptions.InvalidArgumentException;
import com.example.wp_project_original.model.exceptions.InvalidUserCredentialsException;
import com.example.wp_project_original.model.exceptions.PasswordsDoNotMatchException;
import com.example.wp_project_original.repository.UserRepository;
import com.example.wp_project_original.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) {
        if(username==null || username.isEmpty() || password==null || password.isEmpty()){
            throw new InvalidArgumentException();
        }
        return this.userRepository.findByUsernameAndPassword(username,password).orElseThrow(InvalidUserCredentialsException::new);
    }

    @Override
    public User findByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }
}
