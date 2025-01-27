package com.xstock.plutus.utils.validations.constraints;

import com.xstock.plutus.utils.validations.validators.HistoricalIntervalValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = HistoricalIntervalValidator.class)
@Target( { ElementType.FIELD, ElementType.PARAMETER, ElementType.CONSTRUCTOR, ElementType.TYPE_PARAMETER } )
@Retention(RetentionPolicy.RUNTIME)
public @interface HistoricalIntervalConstraint {
    String message() default "must not be blank; must be a positive integer followed by a space and 'day', 'month' or 'year'";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
