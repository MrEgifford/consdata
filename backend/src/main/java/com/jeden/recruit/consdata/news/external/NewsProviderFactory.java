package com.jeden.recruit.consdata.news.external;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jeden.recruit.consdata.config.ConfPropKeys;
import com.jeden.recruit.consdata.news.external.rest.RestNewsProvider;
import com.jeden.recruit.consdata.news.external.soap.SoapNewsProvider;

@Configuration
public class NewsProviderFactory {
	
	@Bean
	@ConditionalOnProperty(name=ConfPropKeys.NEWS_PROVIDER_TYPE, havingValue="rest")
	public NewsProvider restNewsProvider() {
		return new RestNewsProvider();
	}
	
	@Bean
	@ConditionalOnProperty(name=ConfPropKeys.NEWS_PROVIDER_TYPE, havingValue="soap")
	public NewsProvider soapNewsProvider() {
		return new SoapNewsProvider();
	}
	
}
