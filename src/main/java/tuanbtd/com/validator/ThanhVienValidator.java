package tuanbtd.com.validator;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import tuanbtd.com.DTO.ThanhVienForm;

public class ThanhVienValidator implements Validator {

    private EmailValidator emailValidator = EmailValidator.getInstance();
    
    @Override
    public boolean supports(Class<?> clazz) {
        return ThanhVienForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ThanhVienForm tvForm = (ThanhVienForm) target;
        if(tvForm.getUsername().length()==0 ||tvForm.getUsername()==null) {
            errors.rejectValue("username", "field.username");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "hoTen", "field.hoTen");
        
        if(tvForm.getPassword().length()<6||tvForm.getPassword()==null ) {
            errors.rejectValue("password", "field.password");
        }
        
        if(!tvForm.getPassword().equals(tvForm.getRepeatPassword())) {
            errors.rejectValue("repeatPassword", "field.repeatPassword");
        }
        
        if(!emailValidator.isValid(tvForm.getEmail())) {
            errors.rejectValue("email", "field.email");
        }
    }

}
