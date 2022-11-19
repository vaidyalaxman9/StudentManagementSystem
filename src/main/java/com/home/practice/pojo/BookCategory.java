package com.home.practice.pojo;

public class BookCategory {

	public int bookCategoryId;
	public String categoryName;
	public String categoryDescription;

	public int getBookCategoryId() {
		return bookCategoryId;
	}

	public void setBookCategoryId(int bookCategoryId) {
		this.bookCategoryId = bookCategoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public BookCategory(int bookCategoryId, String categoryName, String categoryDescription) {
		super();
		this.bookCategoryId = bookCategoryId;
		this.categoryName = categoryName;
		this.categoryDescription = categoryDescription;
	}

	public BookCategory() {
		super();
	}
}
