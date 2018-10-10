package com.jeden.recruit.consdata.news.external.rest;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.net.URI;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import com.jeden.recruit.consdata.config.ConfigurationProps;
import com.jeden.recruit.consdata.cons.PropertyKey;
import com.jeden.recruit.consdata.exception.handler.RestExceptionHandler;
import com.jeden.recruit.consdata.news.external.rest.dto.NewsResponse;

@RunWith(MockitoJUnitRunner.class)
public class RestNewsProviderTest {
	
	private static final String EXTERNAL_API_PATH = "externalApiPath";

	private static final String TEST_API_KEY = "testApiKey";

	@Mock
	private ConfigurationProps configuration;
	
	@Mock
	private RestTemplateBuilder restTemplateBuilder;
	
	
	@InjectMocks
	private RestNewsProvider newsProvider;
	
	
	@Test
	public void testFindAllForParams() {
		RestTemplate restTemplate = mock(RestTemplate.class);
		Map<String, String> urlParams = Collections.singletonMap("testKey", "testValue");
		
		when(restTemplateBuilder.errorHandler(Mockito.any(RestExceptionHandler.class)))
			.thenReturn(restTemplateBuilder);
		when(restTemplateBuilder.build())
			.thenReturn(restTemplate);
		when(configuration.getProperty(PropertyKey.API_KEY))
			.thenReturn(Optional.of(TEST_API_KEY));
		when(configuration.getProperty(PropertyKey.EXTERNAL_API_PATH))
			.thenReturn(Optional.of(EXTERNAL_API_PATH));
		
		newsProvider.findAllForParams(urlParams);
		
		ArgumentCaptor<URI> urlCaptor = ArgumentCaptor.forClass(URI.class);
		
		verify(restTemplateBuilder)
			.build();
		verify(restTemplate)
			.getForObject(urlCaptor.capture(), Mockito.eq(NewsResponse.class));
		
		String generatedURL = urlCaptor.getValue().toString();
		assertTrue(generatedURL.contains(EXTERNAL_API_PATH));
		assertTrue(generatedURL.contains(TEST_API_KEY));
		
		
	}

}
