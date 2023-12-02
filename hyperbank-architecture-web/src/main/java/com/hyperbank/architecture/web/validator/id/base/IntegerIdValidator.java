package com.hyperbank.architecture.web.validator.id.base;

import com.hyperbank.architecture.web.validator.id.IdValidator;

public interface IntegerIdValidator extends IdValidator<Integer> {

	@Override
	default Integer getZeroValue() {
		return 0;
	}
	
}
