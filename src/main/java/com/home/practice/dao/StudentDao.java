package com.home.practice.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.home.practice.pojo.Student;
import com.home.practice.utility.DatabaseConnection;

@Repository
public class StudentDao {

	@Autowired
	DatabaseConnection databaseConnection;

	public List<Student> getAllStudents() {
		List<Student> studentList = new ArrayList<Student>();
		try {
			Connection con = databaseConnection.getDatabaseConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(
					"select s.student_Id, s.std_Name, s.mobile, s.address, s.notes, c.class_Name from student s left join class c on s.student_class_Id = c.class_Id;");

			while (rs.next()) {
				Student s = new Student(rs.getInt("student_Id"), rs.getString("std_Name"), rs.getString("mobile"),
						rs.getString("address"), rs.getString("notes"), rs.getString("class_Name"));
				studentList.add(s);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return studentList;
	}
}