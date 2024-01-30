package com.hyperbank.architecture.web.service.impl;

import org.springframework.stereotype.Service;

import com.hyperbank.architecture.web.documents.UserError;
import com.hyperbank.architecture.web.repository.UserErrorRepository;
import com.hyperbank.architecture.web.service.UserErrorService;

import io.github.paulmarcelinbejan.toolbox.web.response.ExceptionResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserErrorServiceImpl implements UserErrorService {

	private final UserErrorRepository userErrorRepository;
	
	@Override
	public UserError insertUserError(Exception exception, ExceptionResponse exceptionResponse) {
		UserError userError = new UserError(exception, exceptionResponse);
		userError = userErrorRepository.insert(userError);
		return userError;
	}

}
