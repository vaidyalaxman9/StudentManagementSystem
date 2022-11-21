package com.home.practice.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.practice.dao.BooksDao;
import com.home.practice.pojo.Books;

@Service
public class BooksBo {

	@Autowired
	BooksDao booksDao;

	public List<Books> getAllBooks() {
		return booksDao.getAllBooks();
	}

	public List<Books> addBooksInExistingList(List<Books> booksList, int bookId, String bookName, String className) {
		Books b = new Books(bookId, bookName, className);
		booksList.add(b);
		return booksList;
	}

	public List<Books> getBooksData() {
		return booksDao.fetchBooksData();
	}

	public boolean addBooks(String bookName, int classId) {
		int updateCount = booksDao.saveBooks(bookName, classId);
		if (updateCount > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean updateBooks(String bookName, int className, int bookId) {
		int updateCount = booksDao.updateBooks(bookName, className, bookId);
		if (updateCount > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean deleteBooks(Integer bookId) {
		int deletCount = booksDao.deleteBooks(bookId);
		if (deletCount > 0) {
			return true;
		} else {
			return false;
		}
	}
}