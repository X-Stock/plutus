package com.xstock.plutus.utils.validations.constraints;

import com.xstock.plutus.utils.validations.validators.IntersectTickerValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = IntersectTickerValidator.class)
@Target( { ElementType.FIELD, ElementType.PARAMETER, ElementType.CONSTRUCTOR, ElementType.TYPE_PARAMETER } )
@Retention(RetentionPolicy.RUNTIME)
public @interface IntersectTickerConstraint {
    int minSize() default 2;
    int maxSize() default Integer.MAX_VALUE;

    String message() default "must have at least 2 tickers; each ticker must not be blank";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
