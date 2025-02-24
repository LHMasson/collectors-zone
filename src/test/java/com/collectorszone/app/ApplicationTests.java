package com.collectorszone.app;

import com.collectorszone.app.service.MarvelService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
class ApplicationTests {

	@Test
	void contextLoads() {
		MarvelService marvelService = new MarvelService();
		String hash = marvelService.buildApiUrl("comics");
		System.out.println(hash);
	}

}
