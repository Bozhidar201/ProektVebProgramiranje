package com.example.wp_project_original.service;

import com.example.wp_project_original.model.User;

public interface AuthService {
    User login(String username, String password);
    User findByUsername(String username);
}
