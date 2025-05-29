package com.vlv.vo;

import com.vlv.annotations.ValidStatusTransition;
import com.vlv.entity.AccountStatus;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AccountStatusValidator implements ConstraintValidator<ValidStatusTransition, AccountStatus> {
    @Override
    public boolean isValid(AccountStatus newStatus, ConstraintValidatorContext context) {
        // 实现业务逻辑，例如不允许从 DEACTIVATED 直接切换到 CREATED
        return true;
    }
}