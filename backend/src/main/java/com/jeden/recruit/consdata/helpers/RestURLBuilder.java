package com.jeden.recruit.consdata.helpers;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

public class RestURLBuilder {
	
	private final String CATEGORY_PARAM = "category";
	private final String COUNTRY_PARAM = "country";

	
	private final String apiURL;
	
	private final String apiKey;
	
	private MultiValueMap<String, String> params;
	

	private RestURLBuilder(String apiURL, String apiKey) {
		this.apiURL = apiURL;
		this.apiKey = apiKey;
		params = new LinkedMultiValueMap<>();
	}
	
	public static RestURLBuilder createRestURL(String apiURL, String apiKey) {
		return new RestURLBuilder(apiURL, apiKey);
	}
	
	public RestURLBuilder forCountry(String countryCode) {
		params.add(COUNTRY_PARAM, countryCode);
		return this;
	}
	
	public RestURLBuilder forCategory(String category) {
		params.add(CATEGORY_PARAM, category);
		return this;
	}
	
	public URI buildURL() {
		return UriComponentsBuilder.newInstance()
			.scheme("https")
			.host(this.apiURL)
			.queryParams(params)
			.queryParam("apiKey", apiKey)
			.build().toUri();
		
	}
	
	

}
