package com.jeden.recruit.consdata.cons;

public enum PropertyKey {
	
	EXTERNAL_API_TYPE("externalApiType"),
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
