package com.minaz.marvel.characters.org.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties

public class MarvelCharacter {

	private int id;
	private Comics comics;
	private Stories stories;

	@Override
	public String toString() {
		return 	"ID: " + id +
				"Total Comics: " + comics +
				"Total Stories: " + stories;		
	}
	
	
}
