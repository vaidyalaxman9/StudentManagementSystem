package com.home.practice.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.home.practice.pojo.BookCategory;
import com.home.practice.utility.DatabaseConnection;

@Repository
public class BookCategoryDao {

	@Autowired
	DatabaseConnection databaseConnection;

	public List<BookCategory> getAllBookCategory() {
		List<BookCategory> bookcategoryList = new ArrayList<BookCategory>();
		try {
			Connection con = databaseConnection.getDatabaseConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from bookcategory");

			while (rs.next()) {
				BookCategory bc = new BookCategory(rs.getInt("book_category_Id"), rs.getString("category_Name"),
						rs.getString("category_Description"));
				bookcategoryList.add(bc);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return bookcategoryList;
	}

	public BookCategory getBookCategoryById(Integer bookCategoryId) {
		BookCategory bookcategory = new BookCategory();
		try {
			Connection con = databaseConnection.getDatabaseConnection();

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from bookcategory where book_category_Id = " + bookCategoryId);

			while (rs.next()) {
				bookcategory = new BookCategory(rs.getInt("book_category_Id"), rs.getString("category_Name"),
						rs.getString("category_Description"));
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return bookcategory;
	}

	public List<BookCategory> fetchBookCategoryData() {
		List<BookCategory> bookcategoryList = new ArrayList<BookCategory>();
		try {
			Connection con = databaseConnection.getDatabaseConnection();

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from bookcategory");

			while (rs.next()) {
				BookCategory bc = new BookCategory(rs.getInt(1), rs.getString(2), rs.getString(3));
				bookcategoryList.add(bc);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return bookcategoryList;
	}

	public int saveBookCategory(String categoryName, String categoryDescription) {
		int updateCount = 0;
		try {
			Connection con = databaseConnection.getDatabaseConnection();

			Statement stmt = con.createStatement();
			String query = "INSERT INTO bookcategory (category_Name, category_Description) values ('" + categoryName
					+ "', '" + categoryDescription + "')";
			updateCount = stmt.executeUpdate(query);

			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return updateCount;

	}

	public int updateBookCategory(String categoryName, String categoryDescription, int bookCategoryId) {
		int updateCount = 0;
		try {
			Connection con = databaseConnection.getDatabaseConnection();

			Statement stmt = con.createStatement();
			String query = "update bookcategory set category_Name = '" + categoryName + "', category_Description='"
					+ categoryDescription + "' where book_category_Id = " + bookCategoryId;
			updateCount = stmt.executeUpdate(query);

			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return updateCount;
	}

	public int deleteBookCategory(Integer bookCategoryId) {
		int udpateCount = 0;
		try {
			Connection con = databaseConnection.getDatabaseConnection();

			Statement stmt = con.createStatement();
			String query = "delete from bookcategory where book_category_Id = " + bookCategoryId;
			udpateCount = stmt.executeUpdate(query);

			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return udpateCount;
	}
}
