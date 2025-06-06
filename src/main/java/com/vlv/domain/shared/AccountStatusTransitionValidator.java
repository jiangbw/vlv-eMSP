package com.vlv.domain.shared;

import com.vlv.domain.account.AccountStatus;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AccountStatusTransitionValidator
        implements ConstraintValidator<ValidStatusTransition, AccountStatus> {

    @Override
    public boolean isValid(
            AccountStatus newStatus,
            ConstraintValidatorContext context
    ) {

        return true;
    }
}
