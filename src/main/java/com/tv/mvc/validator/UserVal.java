package com.tv.mvc.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.tv.mvc.models.*;
 
@Component
public class UserVal implements Validator {
    

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }
    

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        
        if (!user.getPasswordConfirmation().equals(user.getPassword())) {
     
            errors.rejectValue("password", "Malo");
        }         
    }
}