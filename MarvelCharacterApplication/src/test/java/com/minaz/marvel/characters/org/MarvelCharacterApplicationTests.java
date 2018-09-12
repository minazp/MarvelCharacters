package com.minaz.marvel.characters.org;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MarvelCharacterApplicationTests {
	
	@Autowired 
	private MarvelAPIClient client;
	
	@LocalServerPort
	private int port;

	@Test
	public void contextLoads() {
		assertThat(client).isNotNull();
	}
	
	@Test
	public void testCount() {
		assertThat(this.client.getData(786));
	}

}
