package com.example.wp_project_original.service.Impl;

import com.example.wp_project_original.model.User;
import com.example.wp_project_original.model.enumerations.Role;
import com.example.wp_project_original.model.exceptions.InvalidArgumentException;
import com.example.wp_project_original.model.exceptions.InvalidUserIdException;
import com.example.wp_project_original.model.exceptions.PasswordsDoNotMatchException;
import com.example.wp_project_original.repository.UserRepository;
import com.example.wp_project_original.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User create(String username, String password, Role role) {
        User user = new User(username,password,role);
        this.userRepository.save(user);
        return user;
    }

    @Override
    public User findByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public User update(Long id, String username, String password, Role role) {
        User user = this.findById(id);
        user.setUsername(username);
        user.setPassword(password);
        this.userRepository.save(user);
        return user;
    }

    @Override
    public User findById(Long id) {
        return this.userRepository.findById(id).orElseThrow(InvalidUserIdException::new);
    }

    @Override
    public User register(String username, String password, String repeatPassword, Role role) {
        if(username==null || username.isEmpty() || password==null || password.isEmpty()){
            throw new InvalidArgumentException();
        }
        if(!password.equals(repeatPassword)){
            throw new PasswordsDoNotMatchException();
        }

        User user = new User(username,password,role);
        this.userRepository.save(user);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepository.findByUsername(username);
    }
}
