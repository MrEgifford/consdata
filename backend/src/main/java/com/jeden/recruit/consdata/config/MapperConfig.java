package com.jeden.recruit.consdata.config;

import java.util.Arrays;


import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
	
	@Bean
	public DozerBeanMapper createBeanMapper() {
		DozerBeanMapper mapper = new DozerBeanMapper(Arrays.asList("mappings.xml", "dozerJdk8Converters.xml"));
		return mapper;
	}

}
