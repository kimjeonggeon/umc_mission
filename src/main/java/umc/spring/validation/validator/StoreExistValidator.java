package umc.spring.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.ApiPayload.code.status.ErrorStatus;
import umc.spring.domain.Store;
import umc.spring.service.StoreService.StoreQueryService;
import umc.spring.validation.annotation.ExistStore;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class StoreExistValidator implements ConstraintValidator<ExistStore, Long> {

    private final StoreQueryService storeQueryService;

    @Override
    public void initialize(ExistStore constraintAnnotaition){
        ConstraintValidator.super.initialize(constraintAnnotaition);
    }
    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context){
        Optional<Store> target = storeQueryService.findStore(value);
        if(target.isEmpty()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.STORE_NOT_FOUND.toString()).addConstraintViolation();
            return  false;
        }
        return true;
    }


}
