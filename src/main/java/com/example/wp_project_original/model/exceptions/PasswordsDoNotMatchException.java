package com.example.wp_project_original.model.exceptions;

public class PasswordsDoNotMatchException extends RuntimeException{
    public PasswordsDoNotMatchException(){
        super("Passwords Do Not Match Exception");
    }
}
