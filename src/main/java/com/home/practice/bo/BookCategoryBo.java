package com.home.practice.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.practice.dao.BookCategoryDao;
import com.home.practice.pojo.BookCategory;

@Service
public class BookCategoryBo {

	@Autowired
	BookCategoryDao bookcategoryDao;

	public List<BookCategory> getAllBookCategory() {
		return bookcategoryDao.getAllBookCategory();
	}

	public BookCategory getBookCategoryData(Integer bookCategoryId) {
		return bookcategoryDao.getBookCategoryById(bookCategoryId);
	}

	public List<BookCategory> addBookCategoryInExistingList(List<BookCategory> bookcategoryList, int bookCategoryId,
			String categoryName, String categoryDescription) {
		BookCategory bc = new BookCategory(bookCategoryId, categoryName, categoryDescription);
		bookcategoryList.add(bc);
		return bookcategoryList;
	}

	public List<BookCategory> getBookCategoryData() {
		return bookcategoryDao.fetchBookCategoryData();
	}

	public boolean addBookCategory(String categoryName, String categoryDescription) {
		int updateCount = bookcategoryDao.saveBookCategory(categoryName, categoryDescription);
		if (updateCount > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean updateBookCategory(String categoryName, String categoryDescription, int bookCategoryId) {
		int updateCount = bookcategoryDao.updateBookCategory(categoryName, categoryDescription, bookCategoryId);
		if (updateCount > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean deleteBookCategory(Integer bookCategoryId) {
		int deletCount = bookcategoryDao.deleteBookCategory(bookCategoryId);
		if (deletCount > 0) {
			return true;
		} else {
			return false;
		}
	}
}