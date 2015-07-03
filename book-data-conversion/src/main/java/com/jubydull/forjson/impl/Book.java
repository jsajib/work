package com.jubydull.forjson.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.jubydull.forjson.JSONAble;

public class Book implements JSONAble {

	private String name;
	private String[] authors;
	private String publishedDate;

	public Book() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getAuthors() {
		return authors;
	}

	public void setAuthors(String[] authors) {
		this.authors = authors;
	}

	public String getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}

	private JSONArray getAuthorJson() {
		JSONArray json = new JSONArray();
		for (String author : authors) {
			json.add(author);
		}
		return json;
	}

	public JSONObject toJSON() {

		Map jsonMap = new LinkedHashMap();
		jsonMap.put("name", getName());
		jsonMap.put("authors", getAuthorJson());
		jsonMap.put("published�date", getPublishedDate());

		JSONObject jsonDomainObject = new JSONObject();
		jsonDomainObject.put("book", jsonMap);

		return jsonDomainObject;
	}

}
