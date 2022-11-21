package com.home.practice.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.home.practice.pojo.Books;
import com.home.practice.utility.DatabaseConnection;

@Repository
public class BooksDao {

	@Autowired
	DatabaseConnection databaseConnection;

	public List<Books> getAllBooks() {
		List<Books> booksList = new ArrayList<Books>();
		try {
			Connection con = databaseConnection.getDatabaseConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(
					"select b.book_Id, b.book_Name, c.class_Name from books b left join class c on b.book_class_Id = c.class_Id;");

			while (rs.next()) {
				Books b = new Books(rs.getInt("book_Id"), rs.getString("book_Name"), rs.getString("class_Name"));
				booksList.add(b);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return booksList;
	}

	public Books getBooksById(Integer bookId) {
		Books books = new Books();
		try {
			Connection con = databaseConnection.getDatabaseConnection();

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from books where book_Id = " + bookId);

			while (rs.next()) {
				books = new Books(rs.getInt("book_Id"), rs.getString("book_Name"), rs.getString("book_class_Id"));
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return books;
	}

	public List<Books> fetchBooksData() {
		List<Books> booksList = new ArrayList<Books>();
		try {
			Connection con = databaseConnection.getDatabaseConnection();

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from books");

			while (rs.next()) {
				Books b = new Books(rs.getInt(1), rs.getString(2), rs.getString(3));
				booksList.add(b);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return booksList;
	}

	public int saveBooks(String bookName, int classId) {
		int updateCount = 0;
		try {
			Connection con = databaseConnection.getDatabaseConnection();

			Statement stmt = con.createStatement();
			String query = "INSERT INTO books (book_Name, book_class_Id) values ('" + bookName + "', " + classId + ")";
			updateCount = stmt.executeUpdate(query);

			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return updateCount;

	}

	public int updateBooks(String bookName, int className, int bookId) {
		int updateCount = 0;
		try {
			Connection con = databaseConnection.getDatabaseConnection();

			Statement stmt = con.createStatement();
			String query = "update books set book_Name = '" + bookName + "',  book_class_Id = " + className
					+ " where book_Id = " + bookId;
			updateCount = stmt.executeUpdate(query);

			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return updateCount;
	}

	public int deleteBooks(Integer bookId) {
		int udpateCount = 0;
		try {
			Connection con = databaseConnection.getDatabaseConnection();

			Statement stmt = con.createStatement();
			String query = "delete from books where book_Id = " + bookId;
			udpateCount = stmt.executeUpdate(query);

			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return udpateCount;
	}
}
