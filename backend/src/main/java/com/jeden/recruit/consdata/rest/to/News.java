package com.jeden.recruit.consdata.rest.to;

import java.util.List;

import com.jeden.recruit.consdata.helpers.Country;

import lombok.Data;

@Data
public class News {
	
	private Country country;
	//private Category category;
	
	private List<Article> articles;
	
	
	
}
