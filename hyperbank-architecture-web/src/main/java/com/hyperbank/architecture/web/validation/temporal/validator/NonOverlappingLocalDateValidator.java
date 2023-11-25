package com.hyperbank.architecture.web.validation.temporal.validator;

import com.hyperbank.architecture.web.validation.temporal.annotation.NonOverlappingLocalDate;
import com.paulmarcelinbejan.toolbox.utils.time.aware.HistoricalLocalDateAware;
import com.paulmarcelinbejan.toolbox.utils.time.localdate.LocalDateUtils;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NonOverlappingLocalDateValidator implements ConstraintValidator<NonOverlappingLocalDate, HistoricalLocalDateAware> {

    /**
     * Checks if is valid.
     */
    @Override
    public boolean isValid(HistoricalLocalDateAware historicalLocalDateAware, ConstraintValidatorContext constraintValidatorContext) {
    	return LocalDateUtils.isBefore(historicalLocalDateAware.startLocalDate(), historicalLocalDateAware.endLocalDate());
    }
    
}
