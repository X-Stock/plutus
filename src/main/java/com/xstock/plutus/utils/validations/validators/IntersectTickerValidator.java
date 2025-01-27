package com.xstock.plutus.utils.validations.validators;

import com.xstock.plutus.utils.validations.constraints.IntersectTickerConstraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Set;

public class IntersectTickerValidator implements ConstraintValidator<IntersectTickerConstraint, Set<String>> {
    private int minSize;
    private int maxSize;

    @Override
    public void initialize(IntersectTickerConstraint constraintAnnotation) {
        this.minSize = constraintAnnotation.minSize();
        this.maxSize = constraintAnnotation.maxSize();
    }

    @Override
    public boolean isValid(Set<String> value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        if (value.size() < minSize || value.size() > maxSize) {
            return false;
        }
        for (String ticker : value) {
            if (ticker.isBlank()) {
                return false;
            }
        }
        return true;
    }
}
