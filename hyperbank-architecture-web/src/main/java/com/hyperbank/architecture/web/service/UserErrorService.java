package com.hyperbank.architecture.web.service;

import com.hyperbank.architecture.web.documents.UserError;

import io.github.paulmarcelinbejan.toolbox.web.response.ExceptionResponse;

public interface UserErrorService {

	UserError insertUserError(Exception exception, ExceptionResponse exceptionResponse);
	
}
