package com.shankardesigner.ecare.validator;

import com.shankardesigner.ecare.model.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {

        User user = (User) object;

        if(user.getPassword().length() < 6) {
            errors.rejectValue("password","Length","password must be atleast 6 characters");
        }

        if (!user.getPassword().equals(user.getConfirmPassword())) {
            errors.rejectValue("confirmPassword","Match","passwords must match");
        }

        if(user.getRoles() == null) {
            errors.rejectValue("roles","size","Please specify the account type");
        }
    }
}
