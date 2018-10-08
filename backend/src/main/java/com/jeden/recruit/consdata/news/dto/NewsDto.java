package com.jeden.recruit.consdata.news.dto;

import java.util.List;

import com.jeden.recruit.consdata.cons.Category;
import com.jeden.recruit.consdata.cons.Country;

import lombok.Data;

@Data
public class NewsDto {
	
	private Country country;
	
	private Category category;
	
	private List<ArticleDto> articles;
	
	
	
}
