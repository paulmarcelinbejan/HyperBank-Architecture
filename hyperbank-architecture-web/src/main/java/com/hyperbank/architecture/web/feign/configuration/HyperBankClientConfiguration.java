package com.hyperbank.architecture.web.feign.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;
import feign.okhttp.OkHttpClient;

@Configuration
public class HyperBankClientConfiguration {

	@Bean
	public OkHttpClient client() {
		return new OkHttpClient();
	}

	@Bean
	Logger.Level feignLoggerLevel() {
		return Logger.Level.FULL;
	}
	
//	@Bean
//	public ErrorDecoder errorDecoder() {
//	    return new HyperBankErrorDecoder();
//	}

}
