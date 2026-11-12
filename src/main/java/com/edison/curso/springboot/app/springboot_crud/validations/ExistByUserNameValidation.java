package com.edison.curso.springboot.app.springboot_crud.validations;

import org.springframework.stereotype.Component;

import com.edison.curso.springboot.app.springboot_crud.services.UserService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component 
public class ExistByUserNameValidation implements ConstraintValidator<ExistByUserName, String> {

    private final UserService userService;
    

    public ExistByUserNameValidation(UserService userService) {
        this.userService = userService;
    }


    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
       
        if(userService == null) {
            return true;
        }
        return !userService.existsByUsername(username);
    }

}
