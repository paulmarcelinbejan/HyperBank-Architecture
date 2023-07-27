package com.hyperbank.architecture.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.paulmarcelinbejan.toolbox.web.controller.exception.ExceptionRestController;
import com.paulmarcelinbejan.toolbox.web.response.ExceptionResponse;

import feign.FeignException;

@RestControllerAdvice
public class HyperBankExceptionRestController extends ExceptionRestController {

	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = { FeignException.class })
	public ExceptionResponse handleFeignException(FeignException exception) {
		return new ExceptionResponse(exception);
	}

}
