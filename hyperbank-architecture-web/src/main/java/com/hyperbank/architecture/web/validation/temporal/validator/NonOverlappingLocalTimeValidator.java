package com.hyperbank.architecture.web.validation.temporal.validator;

import com.hyperbank.architecture.web.validation.temporal.annotation.NonOverlappingLocalTime;

import io.github.paulmarcelinbejan.toolbox.utils.time.aware.HistoricalLocalTimeAware;
import io.github.paulmarcelinbejan.toolbox.utils.time.localtime.LocalTimeUtils;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NonOverlappingLocalTimeValidator implements ConstraintValidator<NonOverlappingLocalTime, HistoricalLocalTimeAware> {

    /**
     * Checks if is valid.
     */
    @Override
    public boolean isValid(HistoricalLocalTimeAware historicalLocalTimeAware, ConstraintValidatorContext constraintValidatorContext) {
    	return LocalTimeUtils.isBefore(historicalLocalTimeAware.startLocalTime(), historicalLocalTimeAware.endLocalTime());
    }

}
