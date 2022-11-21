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

	public Student getStudentById(Integer studentId) {
		Student student = new Student();
		try {
			Connection con = databaseConnection.getDatabaseConnection();

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from student where student_Id = " + studentId);

			while (rs.next()) {
				student = new Student(rs.getInt("student_Id"), rs.getString("std_Name"), rs.getString("mobile"),
						rs.getString("address"), rs.getString("notes"), rs.getString("student_class_Id"));
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return student;
	}

	public List<Student> fetchStudentData() {
		List<Student> studentList = new ArrayList<Student>();
		try {
			Connection con = databaseConnection.getDatabaseConnection();

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from student");

			while (rs.next()) {
				Student s = new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6));
				studentList.add(s);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return studentList;
	}

	public int saveStudent(String stdName, String mobile, String address, String notes, int classId) {
		int updateCount = 0;
		try {
			Connection con = databaseConnection.getDatabaseConnection();

			Statement stmt = con.createStatement();
			String query = "INSERT INTO student (std_Name,  mobile, address, notes, student_class_Id) values ('"
					+ stdName + "',  '" + mobile + "','" + address + "', '" + notes + "', " + classId + ")";
			updateCount = stmt.executeUpdate(query);

			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return updateCount;

	}

	public int updateStudent(String stdName, String mobile, String address, String notes, int className,
			int studentId) {
		int updateCount = 0;
		try {
			Connection con = databaseConnection.getDatabaseConnection();

			Statement stmt = con.createStatement();
			String query = "update student set std_Name = '" + stdName + "',  mobile='" + mobile + "', address='"
					+ address + "', notes='" + notes + "', student_class_Id = " + className + " where student_Id = "
					+ studentId;
			updateCount = stmt.executeUpdate(query);

			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return updateCount;

	}

	public int deleteStudent(Integer studentId) {
		int udpateCount = 0;
		try {
			Connection con = databaseConnection.getDatabaseConnection();

			Statement stmt = con.createStatement();
			String query = "delete from student where student_Id = " + studentId;
			udpateCount = stmt.executeUpdate(query);

			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return udpateCount;
	}
}