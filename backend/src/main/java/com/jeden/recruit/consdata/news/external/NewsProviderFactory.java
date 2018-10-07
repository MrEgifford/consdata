package com.jeden.recruit.consdata.news.external;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jeden.recruit.consdata.config.ConfPropKeys;
import com.jeden.recruit.consdata.news.external.rest.RestNewsProvider;

@Configuration
public class NewsProviderFactory {
	
	@Bean
	@ConditionalOnProperty(name=ConfPropKeys.NEWS_EXTERNAL_API_TYPE, havingValue="rest")
	public NewsProvider restNewsProvider() {
		return new RestNewsProvider();
	}
	
}
