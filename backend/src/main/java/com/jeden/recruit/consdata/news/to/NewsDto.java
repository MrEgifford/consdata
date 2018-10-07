package com.jeden.recruit.consdata.news.to;

import java.util.List;

import com.jeden.recruit.consdata.helpers.Country;

import lombok.Data;

@Data
public class NewsDto {
	
	private Country country;
	//private Category category;
	
	private List<ArticleDto> articles;
	
	
	
}
