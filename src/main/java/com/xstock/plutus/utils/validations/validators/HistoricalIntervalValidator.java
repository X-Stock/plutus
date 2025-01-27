package com.xstock.plutus.utils.validations.validators;

import com.xstock.plutus.utils.validations.constraints.HistoricalIntervalConstraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class HistoricalIntervalValidator implements ConstraintValidator<HistoricalIntervalConstraint, String> {
    private static final Pattern pattern = Pattern.compile("\\b[1-9]\\d*\\b\\s(day|month|year)s?");

    @Override
    public void initialize(HistoricalIntervalConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String interval, ConstraintValidatorContext context) {
        return !interval.isBlank() &&
                pattern.matcher(interval).matches();
    }
}
