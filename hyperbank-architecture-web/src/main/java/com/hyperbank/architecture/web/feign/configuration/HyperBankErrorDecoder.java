//package com.hyperbank.architecture.web.feign.configuration;
//
//import java.io.IOException;
//import java.io.InputStream;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import feign.Response;
//import feign.codec.ErrorDecoder;
//import io.github.paulmarcelinbejan.toolbox.exception.remoteservice.RemoteServiceException;
//import io.github.paulmarcelinbejan.toolbox.web.response.ExceptionResponse;
//
//public class HyperBankErrorDecoder implements ErrorDecoder {
//
//    @Override
//    public Exception decode(String methodKey, Response response) {
//        ObjectMapper mapper = new ObjectMapper();
//
//        try (InputStream inputStream = response.body().asInputStream())  {
//        	ExceptionResponse exceptionResponse = mapper.readValue(inputStream, ExceptionResponse.class);
//        	return buildRemoteServiceException(exceptionResponse, methodKey);
//      	} catch (IOException e) {
//        	return new ErrorDecoder.Default().decode(methodKey, response);
//		}
//    }
//    
//    private static RemoteServiceException buildRemoteServiceException(ExceptionResponse exceptionResponse, String methodKey) {
//    	return new RemoteServiceException(exceptionResponse.getMessage(), methodKey, exceptionResponse.getUniqueIdentifier());
//    }
//
//}