package com.joy.demo.advice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;

@Configuration
public class LayOutConfig {
	
	// thymeleaf layout
	@Bean
	public LayoutDialect layoutDialect() {
		System.out.println("###layout??");
	    return new LayoutDialect();
	}
}