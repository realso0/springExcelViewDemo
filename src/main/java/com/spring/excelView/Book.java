package com.spring.excelView;

public class Book {
	private String subject;
	private String author;
	private String isbn;
	private String publishDate;
	private int price;
	
	
	public Book(String subject, String author, String isbn, String publishDate, int price){
		this.subject = subject;
		this.author = author;
		this.isbn = isbn;
		this.publishDate = publishDate;
		this.price = price;
	}


	//setter, getter
	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public String getPublishDate() {
		return publishDate;
	}


	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}
	
}
