package com.vlv.annotations;

import com.vlv.entity.AccountStatus;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AccountStatusTransitionValidator
        implements ConstraintValidator<ValidStatusTransition, AccountStatus> {

    @Override
    public boolean isValid(
            AccountStatus newStatus,
            ConstraintValidatorContext context
    ) {
        // 示例：不允许从 DEACTIVATED 切换到 CREATED
        // 根据业务规则实现具体逻辑
//        if (currentStatus == AccountStatus.DEACTIVATED && newStatus == AccountStatus.CREATED) {
//            return false;
//        }
        return true;
    }
}
