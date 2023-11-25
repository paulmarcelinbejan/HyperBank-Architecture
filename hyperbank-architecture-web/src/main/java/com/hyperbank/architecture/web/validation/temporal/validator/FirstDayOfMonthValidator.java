package com.hyperbank.architecture.web.validation.temporal.validator;

import java.time.LocalDate;

import com.hyperbank.architecture.web.validation.temporal.annotation.FirstDayOfMonth;
import com.paulmarcelinbejan.toolbox.utils.time.localdate.LocalDateUtils;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class FirstDayOfMonthValidator implements ConstraintValidator<FirstDayOfMonth, LocalDate> {

    /**
     * Checks if is valid.
     */
    @Override
    public boolean isValid(LocalDate localDate, ConstraintValidatorContext constraintValidatorContext) {
    	return localDate != null && LocalDateUtils.isFirstDayOfMonth(localDate);
    }

}
