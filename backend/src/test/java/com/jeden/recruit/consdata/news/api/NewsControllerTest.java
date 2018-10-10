package com.jeden.recruit.consdata.news.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.jeden.recruit.consdata.ConsdataApplication;
import com.jeden.recruit.consdata.news.core.NewsFacade;

@RunWith(SpringRunner.class)
@WebMvcTest(NewsController.class)
public class NewsControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private NewsFacade newsFacade;
	
	@Test
	public void testGetNews() throws Exception {
		mockMvc
			.perform(MockMvcRequestBuilders.get("/api/news/pl/general/"))
			.andDo(MockMvcResultHandlers.print())
			.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void testGetNewsWithParams() throws Exception {
		mockMvc
			.perform(MockMvcRequestBuilders.get("/api/news/pl/general/?keyword=testKeyword"))
			.andDo(MockMvcResultHandlers.print())
			.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
