package com.jeden.recruit.consdata.news.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.jeden.recruit.consdata.news.dto.NewsDto;

@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)

public class NewsFacadeTestIT {
	
	@Autowired
	private NewsFacade newsFacade;
	

	@Test
	public void testFindForCountry(){
		NewsDto newsForCountry = newsFacade.findForCountry("pl");
		
		assertNotNull(newsForCountry);
		assertEquals(20, newsForCountry.getArticles().size());
	}

}
