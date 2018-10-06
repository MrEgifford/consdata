package com.jeden.recruit.consdata.rest.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jeden.recruit.consdata.ConsdataApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(
		classes = ConsdataApplication.class,
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public class NewsControllerTest {
	
	@Test
	public void testGetNews() {
		
	}

}
