package com.jeden.recruit.consdata.cons;

public enum PropertyKey {
	
	NEWS_PROVIDER_TYPE("newsProviderType"),
	NEWS_PROVIDER_TYPE_REST("rest"),
	
	EXTERNAL_API_PATH("externalApiPath"),
	API_KEY("apiKey");
	
	
	
	private final String propertyKey;
	
	PropertyKey(String aPropertyKey){
		this.propertyKey = aPropertyKey;
	}
	
	public String getPropertyKey() {
		return propertyKey;
	}

}
