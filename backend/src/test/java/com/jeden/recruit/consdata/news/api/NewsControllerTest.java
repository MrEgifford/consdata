package com.jeden.recruit.consdata.news.api;

import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.jeden.recruit.consdata.news.core.NewsFacade;
import com.jeden.recruit.consdata.news.dto.ArticleDto;
import com.jeden.recruit.consdata.news.dto.NewsDto;

@RunWith(SpringRunner.class)
@WebMvcTest(NewsController.class)
@AutoConfigureRestDocs(outputDir = "target/doc")
public class NewsControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private NewsFacade newsFacade;
	
	@Before
	public void initTestData() {
		when(newsFacade.findForParameters(Mockito.any(Map.class)))
			.thenReturn(prepareTestNewsDto());
	}
	
	@Test
	public void testGetNews() throws Exception {
		MvcResult andReturn = mockMvc
			.perform(get("/news/pl/general/"))
			.andDo(print())
			.andExpect(status().isOk())
			.andReturn();
		andReturn.getResponse();
	}
	

	@Test
	public void testGetNewsWithParams() throws Exception {
		mockMvc
			.perform(get("/news/pl/general/?keyword=testKeyword"))
			.andDo(print())
			.andExpect(status().isOk())
			.andDo(document("home", 
					responseFields(fieldWithPath("country").description("Short code of the news country. Ex: 'pl'"),
								   fieldWithPath("category").description("News category. Ex: 'general'"),
								   fieldWithPath("articles").description("List of articles belonging to given category and country"),
								   fieldWithPath("articles[].title").description("Title of the article"),
								   fieldWithPath("articles[].description").description("Short introduction header"),
								   fieldWithPath("articles[].date").description("Publishing time"),
								   fieldWithPath("articles[].sourceName").description("Soure of the article"),
								   fieldWithPath("articles[].articleUrl").description("URL link to original article "),
								   fieldWithPath("articles[].imageUrl").description("URL link to attached article's image if exist. "),
								   fieldWithPath("articles[].author").description("Author of the article"))));
	}
	
	private NewsDto prepareTestNewsDto() {
		NewsDto news = new NewsDto();
		news.setCategory("testCategory");
		news.setCountry("testCountry");
		news.setArticles(prepareTestArticles());
		
		return news;
	}

	private List<ArticleDto> prepareTestArticles() {
		ArticleDto dto = new ArticleDto();
		dto.setArticleUrl("testArticleUrl");
		dto.setAuthor("testAuthor");
		dto.setDate(LocalDateTime.now());
		dto.setDescription("testDescription");
		dto.setImageUrl("testImageUrl");
		
		return Collections.singletonList(dto);
	}

}
