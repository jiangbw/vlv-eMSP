package com.vlv.domain.shared;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AccountStatusTransitionValidator.class)
public @interface ValidStatusTransition {
    String message() default "Invalid status transition";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}