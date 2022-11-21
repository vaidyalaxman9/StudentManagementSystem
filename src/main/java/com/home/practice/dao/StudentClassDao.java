package com.home.practice.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.home.practice.pojo.StudentClass;
import com.home.practice.utility.DatabaseConnection;

@Repository
public class StudentClassDao {

	@Autowired
	DatabaseConnection databaseConnection;

	public List<StudentClass> getAllStudentClass() {
		List<StudentClass> studentclassList = new ArrayList<StudentClass>();
		try {
			Connection con = databaseConnection.getDatabaseConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from class");

			while (rs.next()) {
				StudentClass sc = new StudentClass(rs.getInt("class_Id"), rs.getString("class_Name"),
						rs.getString("notes"));
				studentclassList.add(sc);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return studentclassList;
	}

	public StudentClass getStudentClassById(Integer classId) {
		StudentClass studentclass = new StudentClass();
		try {
			Connection con = databaseConnection.getDatabaseConnection();

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from class where class_Id = " + classId);

			while (rs.next()) {
				studentclass = new StudentClass(rs.getInt("class_Id"), rs.getString("class_Name"),
						rs.getString("notes"));
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return studentclass;
	}

	public List<StudentClass> fetchStudentClassData() {
		List<StudentClass> studentclassList = new ArrayList<StudentClass>();
		try {
			Connection con = databaseConnection.getDatabaseConnection();

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from class");

			while (rs.next()) {
				StudentClass sc = new StudentClass(rs.getInt(1), rs.getString(2), rs.getString(3));
				studentclassList.add(sc);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return studentclassList;
	}

	public int saveStudentClass(String className, String notes) {
		int updateCount = 0;
		try {
			Connection con = databaseConnection.getDatabaseConnection();

			Statement stmt = con.createStatement();
			String query = "INSERT INTO class (class_Name, notes) values ('" + className + "', '" + notes + "')";
			updateCount = stmt.executeUpdate(query);

			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return updateCount;

	}

	public int updateStudentClass(String className, String notes, int classId) {
		int updateCount = 0;
		try {
			Connection con = databaseConnection.getDatabaseConnection();

			Statement stmt = con.createStatement();
			String query = "update class set class_Name = '" + className + "', notes='" + notes + "' where class_Id = "
					+ classId;
			updateCount = stmt.executeUpdate(query);

			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return updateCount;
	}

	public int deleteStudentClass(Integer classId) {
		int udpateCount = 0;
		try {
			Connection con = databaseConnection.getDatabaseConnection();

			Statement stmt = con.createStatement();
			String query = "delete from class where class_Id = " + classId;
			udpateCount = stmt.executeUpdate(query);

			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return udpateCount;
	}
}