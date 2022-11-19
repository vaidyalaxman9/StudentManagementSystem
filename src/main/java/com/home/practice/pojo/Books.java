package com.home.practice.pojo;

public class Books {

	public int bookId;
	public String bookName;
	public String className;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Books(int bookId, String bookName, String className) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.className = className;
	}

	public Books() {
		super();
	}

}
