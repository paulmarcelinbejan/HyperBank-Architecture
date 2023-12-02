package com.hyperbank.architecture.web.validator.id.base;

import java.util.List;

import com.hyperbank.architecture.web.validator.id.IdsValidator;

public interface IntegerIdsValidator extends IdsValidator<Integer, List<Integer>> {

	@Override
	default Integer getZeroValue() {
		return 0;
	}
	
}
