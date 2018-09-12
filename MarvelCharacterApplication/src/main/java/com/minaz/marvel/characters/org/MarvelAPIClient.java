package com.minaz.marvel.characters.org;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.minaz.marvel.characters.org.pojo.Data;

@RestController
@RequestMapping("http://gateway.marvel.com/v1/public/")
public class MarvelAPIClient {
	
	//private static final String BASE = "http://gateway.marvel.com/v1/public/";
	private static final String TS = "1";
	private static final String APIKEY =  "518cc59dca9223c9c23c5a8a5d8ad2bf";
	private static final String HASH =  "2a4f88f7a59d84debbfbc6547b864dd3";
	
	public static final Logger log = LoggerFactory.getLogger(MarvelAPIClient.class);

	public MarvelAPIClient() {
		log.info("Bismillah! You made it!");
	}
	
	@PutMapping("/{ts}")
	public ResponseEntity<?> updateTs(
			  @PathVariable int ts) {
			    return new ResponseEntity<>(TS, HttpStatus.OK);
			}
	
	@PutMapping("/{apikey}")
	public ResponseEntity<?> updateAPIKey(
			  @PathVariable String apiKey) {
			    return new ResponseEntity<>(APIKEY, HttpStatus.OK);
			}
	
	@PutMapping("/{hash}")
	public ResponseEntity<?> updateHash(
			  @PathVariable String hash) {
			    return new ResponseEntity<>(HASH, HttpStatus.OK);
			}
	
	@RequestMapping(value = "/characters")
	public Data getData(@RequestParam(value="count", defaultValue="786") int count) {
		return new Data(count);
	}
	
}
