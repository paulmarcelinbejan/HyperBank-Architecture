package com.hyperbank.architecture.web.validation.temporal.validator;

import com.hyperbank.architecture.web.validation.temporal.annotation.NonOverlappingLocalDateTime;
import com.paulmarcelinbejan.toolbox.utils.time.aware.HistoricalLocalDateTimeAware;
import com.paulmarcelinbejan.toolbox.utils.time.localdatetime.LocalDateTimeUtils;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NonOverlappingLocalDateTimeValidator implements ConstraintValidator<NonOverlappingLocalDateTime, HistoricalLocalDateTimeAware> {

    /**
     * Checks if is valid.
     */
    @Override
    public boolean isValid(HistoricalLocalDateTimeAware historicalLocalDateTimeAware, ConstraintValidatorContext constraintValidatorContext) {
    	return LocalDateTimeUtils.isBefore(historicalLocalDateTimeAware.startLocalDateTime(), historicalLocalDateTimeAware.endLocalDateTime());
    }

}
