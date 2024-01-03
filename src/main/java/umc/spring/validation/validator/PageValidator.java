package umc.spring.validation.validator;

import umc.spring.ApiPayload.code.status.ErrorStatus;
import umc.spring.validation.annotation.CheckPage;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PageValidator implements ConstraintValidator<CheckPage,Integer > {
    @Override
    public void initialize(CheckPage constraintAnnotation){
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context){
        boolean isValid = value < 0;

        if(!isValid){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.PAGE_NUMBER_OUT_OF_RANGE.toString())
                    .addConstraintViolation();
        }
        return  isValid;
    }
}
