package com.minaz.marvel.characters.org.pojo;

import java.util.ArrayList;
import java.util.List;

public class Results {
	
	private ArrayList <MarvelCharacter> marvelCharacters;

	public List <MarvelCharacter> getMarvelCharacters() {
		return marvelCharacters;
	}

	public void setResults(List<MarvelCharacter> marvelCharacters) {
		this.marvelCharacters = (ArrayList<MarvelCharacter>) marvelCharacters;
	}
}
