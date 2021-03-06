package com.distribuida.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {
	private Long id;
	private String isbn;
	private String title;
	private Long author_id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(Long author_id) {
		this.author_id = author_id;
	}
	
	
}
