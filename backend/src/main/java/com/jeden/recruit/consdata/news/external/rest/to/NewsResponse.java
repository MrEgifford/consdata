package com.jeden.recruit.consdata.news.external.rest.to;

import java.util.List;

import lombok.Data;

@Data
public class NewsResponse {
	
	private String status;
	
	private Integer totalResults;
	
	private List<ArticleResponse> articles;

}
