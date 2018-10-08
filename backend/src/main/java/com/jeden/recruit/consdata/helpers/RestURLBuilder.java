package com.jeden.recruit.consdata.helpers;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import com.jeden.recruit.consdata.cons.UrlParams;

public class RestURLBuilder {
	
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
	
	public RestURLBuilder withCountry(String countryCode) {
		params.add(UrlParams.COUNTRY_PARAM, countryCode);
		return this;
	}
	
	public RestURLBuilder withCategory(String category) {
		params.add(UrlParams.CATEGORY_PARAM, category);
		return this;
	}
	
	public RestURLBuilder withParams(Map<String,String> parameters) {
		parameters.forEach((key,value) -> params.add(key, value));
		return this;
	}
	
	public URI buildURL() {
		return UriComponentsBuilder.newInstance()
			.scheme("https")
			.host(this.apiURL)
			.queryParams(params)
			.queryParam(UrlParams.API_KEY_PARAM, apiKey)
			.build()
			.toUri();
	}
	
	

}
