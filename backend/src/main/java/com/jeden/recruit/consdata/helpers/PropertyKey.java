package com.jeden.recruit.consdata.helpers;

public enum PropertyKey {
	
	API_KEY("api_key");
	
	private String propertyKey;
	
	PropertyKey(String aPropertyKey){
		this.propertyKey = aPropertyKey;
	}
	
	public String getPropertyKey() {
		return propertyKey;
	}

}
