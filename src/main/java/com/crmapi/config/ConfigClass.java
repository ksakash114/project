package com.crmapi.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.crmapi.repository.Commentsrepository;

@Configuration
public class ConfigClass {

	
	@Bean
	public ModelMapper getMapper()
	{
		return new ModelMapper();
	}
	
}
