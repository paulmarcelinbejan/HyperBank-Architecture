package com.hyperbank.architecture.web.validator.id;

import com.paulmarcelinbejan.architecture.sniper.validator.Validator;

public interface IdValidator<
		ID extends Number & Comparable<? super ID>> 
		extends Validator<ID>, BaseIdValidator<ID> {

    @Override
    default void validate(ID id) {
        validateId(id);
    }
    
}