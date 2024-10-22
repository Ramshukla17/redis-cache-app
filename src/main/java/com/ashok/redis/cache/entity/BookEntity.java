package com.ashok.redis.cache.entity;

import java.io.Serializable;

public class BookEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer bookId;
	private String bookName;
	
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	@Override
	public String toString() {
		return "BookEntity [bookId=" + bookId + ", bookName=" + bookName + "]";
	}
}
