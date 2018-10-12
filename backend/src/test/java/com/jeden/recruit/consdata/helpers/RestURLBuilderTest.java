package com.jeden.recruit.consdata.helpers;

import static org.junit.Assert.assertTrue;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class RestURLBuilderTest {
	
	private String testApiKey = "apiKey";
	
	private String testApiURL = "externalApiURL";
	
	@Test
	public void testURLBuild_noParam() {
		
		URI builtURI = RestURLBuilder.createRestURL(testApiURL, testApiKey)
			.buildURL();
		
		assertTrue(builtURI.toString().contains(testApiURL));
		assertTrue(builtURI.toString().contains(testApiKey));
		assertTrue(builtURI.toString().contains("http"));
		
	}
	
	@Test
	public void testURLBuild_oneParam() {
		String countryCode = "pl";
		
		URI builtURI = RestURLBuilder.createRestURL(testApiURL, testApiKey)
			.withCountry(countryCode).buildURL();
		
		assertTrue(builtURI.toString().contains(countryCode));
	}
	
	@Test
	public void testURLBuild_manyParams() {
		Map<String,String> parameters = new HashMap<String,String>();
		parameters.put("testKey", "testValue");
		parameters.put("testKey2", "testValue2");
		
		URI builtURI = RestURLBuilder.createRestURL(testApiURL, testApiKey)
				.withParams(parameters).buildURL();
		
		assertTrue(builtURI.toString().contains("testKey=testValue"));
		assertTrue(builtURI.toString().contains("testKey2=testValue2"));
	}


}
