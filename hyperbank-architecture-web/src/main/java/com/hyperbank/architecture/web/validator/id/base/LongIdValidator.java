package com.hyperbank.architecture.web.validator.id.base;

import com.hyperbank.architecture.web.validator.id.IdValidator;

public interface LongIdValidator extends IdValidator<Long> {

	@Override
	default Long getZeroValue() {
		return 0L;
	}

}
