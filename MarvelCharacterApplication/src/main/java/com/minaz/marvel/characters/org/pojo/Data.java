package com.minaz.marvel.characters.org.pojo;

import java.util.ArrayList;
import java.util.List;

public class Data {
	
	private int offset;//offset of results returned in this request
	private int limit;//limit of results returned in this request
	private int total;//total amount of results available
	private int count;//amount of results returned in this request
	private ArrayList <Object> results;//results returned for this request
	
	public Data(int offset, int limit, int total, int count, ArrayList <Object> results) {
		this.offset = offset;
		this.limit = limit;
		this.total = total;
		this.count = count;
		this.results = results;
	}
	
	public Data(int count) {
		this.count = count;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List <Object> getResults() {
		return results;
	}

	public void setResults(List <Object> data) {
		this.results = (ArrayList<Object>) data;
	}

}
