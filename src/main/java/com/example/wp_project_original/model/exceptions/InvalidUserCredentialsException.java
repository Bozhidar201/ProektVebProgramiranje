package com.example.wp_project_original.model.exceptions;

public class InvalidUserCredentialsException extends RuntimeException{
    public InvalidUserCredentialsException(){
        super("Невалидно корисничко име или лозинка");
    }
}
