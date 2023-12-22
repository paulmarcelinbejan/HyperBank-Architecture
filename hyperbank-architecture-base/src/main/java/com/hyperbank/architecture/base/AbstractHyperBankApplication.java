package com.hyperbank.architecture.base;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractHyperBankApplication {

	@Value("${spring.application.name}")
	private String applicationName;
	
	@Bean
	CommandLineRunner commandLineRunner() {
		return x -> presentMe();
	}
	
	private void presentMe() {
		log.info("Hello, it's me, '{}' !!!", applicationName);
	}
	
}
