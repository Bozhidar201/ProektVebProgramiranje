package com.example.wp_project_original.service;

import com.example.wp_project_original.model.User;
import com.example.wp_project_original.model.enumerations.Role;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User create(String username, String password, Role role);
    User findByUsername(String username);
    User update(Long id, String username, String password, Role role);
    User findById(Long id);
    User register(String username, String password, String repeatPassword, Role role);
}
