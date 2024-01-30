package com.hyperbank.architecture.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hyperbank.architecture.web.service.UserErrorService;

import feign.FeignException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import io.github.paulmarcelinbejan.toolbox.web.controller.exception.ExceptionRestController;
import io.github.paulmarcelinbejan.toolbox.web.response.ExceptionResponse;
import lombok.RequiredArgsConstructor;

@RestControllerAdvice
@RequiredArgsConstructor
public class HyperBankExceptionRestController extends ExceptionRestController {

	private final UserErrorService userErrorService;
	
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = { FeignException.class })
	public ExceptionResponse handleFeignException(FeignException exception) {
		return new ExceptionResponse(exception);
	}
	
	@Override
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = { TechnicalException.class })
	public ExceptionResponse handleTechnicalException(TechnicalException exception) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(exception);
		userErrorService.insertUserError(exception, exceptionResponse);
		return exceptionResponse;
	}

	@Override
	@ResponseBody
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ExceptionResponse handleAllUncaughtException(Exception exception) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(exception);
		userErrorService.insertUserError(exception, exceptionResponse);
		return exceptionResponse;
	}

}
