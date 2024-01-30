package com.hyperbank.architecture.web.documents;

import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.paulmarcelinbejan.toolbox.exception.utils.ExceptionUtils;
import io.github.paulmarcelinbejan.toolbox.web.response.ExceptionResponse;
import lombok.AllArgsConstructor;

@Document
@AllArgsConstructor
public class UserError {
	
	@Id
	@JsonProperty
	private final String uniqueIdentifier;
	
	@JsonProperty
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private final Instant timestampUTC;
	
	@JsonProperty
	private final String exceptionType;
	
	@JsonProperty
	private final String message;
	
	@JsonProperty
	private final String stackTrace;
	
	public UserError(Exception e, ExceptionResponse exceptionResponse) {
		this.uniqueIdentifier = exceptionResponse.getUniqueIdentifier();
		this.timestampUTC = exceptionResponse.getTimestampUTC();
		this.exceptionType = exceptionResponse.getExceptionType();
		this.message = exceptionResponse.getMessage();
		this.stackTrace = ExceptionUtils.getStackTrace(e);
	}
	
}
