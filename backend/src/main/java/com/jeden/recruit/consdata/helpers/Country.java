package com.jeden.recruit.consdata.helpers;

public enum Country {
	
	PL("pl"),
	EN("en");
	
	private String shortCode;
	
	private Country(String isoShortCode) {
		this.shortCode = isoShortCode;
	}
	
	
	public String getShortCode() {
		return shortCode;
	}
	
	@Override
	public String toString() {
		return shortCode;
	}
	

}
