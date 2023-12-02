package com.hyperbank.architecture.web.validator.id.base;

import java.util.List;

import com.hyperbank.architecture.web.validator.id.IdsValidator;

public interface LongIdsValidator extends IdsValidator<Long, List<Long>> {

	@Override
	default Long getZeroValue() {
		return 0L;
	}
	
}
