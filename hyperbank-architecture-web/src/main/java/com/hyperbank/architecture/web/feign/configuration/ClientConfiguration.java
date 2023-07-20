package com.hyperbank.architecture.web.feign.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;
import feign.okhttp.OkHttpClient;

@Configuration
public class ClientConfiguration {

	@Bean
	public OkHttpClient client() {
		return new OkHttpClient();
	}

	@Bean
	Logger.Level feignLoggerLevel() {
		return Logger.Level.BASIC;
	}

}
