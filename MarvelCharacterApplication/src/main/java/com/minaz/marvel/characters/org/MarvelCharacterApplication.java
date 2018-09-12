package com.minaz.marvel.characters.org;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.minaz.marvel.characters.org.pojo.Data"})
public class MarvelCharacterApplication {
	
	public static final Logger log = LoggerFactory.getLogger(MarvelCharacterApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MarvelCharacterApplication.class);
	}
}
