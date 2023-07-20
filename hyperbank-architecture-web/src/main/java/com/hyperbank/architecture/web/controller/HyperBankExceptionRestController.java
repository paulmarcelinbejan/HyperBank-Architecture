package com.hyperbank.architecture.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.paulmarcelinbejan.toolbox.web.controller.exception.ExceptionRestController;
import com.paulmarcelinbejan.toolbox.web.dto.ExceptionResponse;

import feign.FeignException;

@RestControllerAdvice
public class HyperBankExceptionRestController extends ExceptionRestController {

	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = { FeignException.class })
	public ExceptionResponse handleFeignException(FeignException exception) {
		//Example of ugly message: "[500 ] during [GET] to [http://localhost:9888/api/location/10] [MapsRemoteService#findLocationById(Long)]: [eb63d229-af37-42c2-8056-fa63d727a813 - No Location found with the id: 10]"
		String uglyMessage = exception.getMessage();
		int startIndex = uglyMessage.lastIndexOf('[');
		int endIndex = uglyMessage.lastIndexOf(']');
		String message = uglyMessage.substring(startIndex + 1, endIndex);
		return new ExceptionResponse(exception, message);
	}

}
