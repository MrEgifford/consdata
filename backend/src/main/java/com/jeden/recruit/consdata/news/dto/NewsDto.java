package com.jeden.recruit.consdata.news.dto;

import java.util.List;

import lombok.Data;

@Data
public class NewsDto {
	
	private String country;
	
	private String category;
	
	private List<ArticleDto> articles;
	
	
	
}
