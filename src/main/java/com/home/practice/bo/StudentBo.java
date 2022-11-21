package com.home.practice.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.practice.dao.StudentDao;
import com.home.practice.pojo.Student;

@Service
public class StudentBo {

	@Autowired
	StudentDao studentDao;

	public List<Student> getAllStudents() {
		return studentDao.getAllStudents();
	}

	public Student getStudentData(Integer studentId) {
		return studentDao.getStudentById(studentId);
	}

	public List<Student> addStudentInExistingList(List<Student> studentList, int studentId, String stdName,
			String mobile, String address, String notes, String className) {
		Student s = new Student(studentId, stdName, mobile, address, notes, className);
		studentList.add(s);
		return studentList;
	}

	public List<Student> getStudentData() {
		return studentDao.fetchStudentData();
	}

	public boolean addStudent(String stdName, String mobile, String address, String notes, int classId) {
		int updateCount = studentDao.saveStudent(stdName, mobile, address, notes, classId);
		if (updateCount > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean updateStudent(String stdName, String mobile, String address, String notes, int className,
			int studentId) {
		int updateCount = studentDao.updateStudent(stdName, mobile, address, notes, className, studentId);
		if (updateCount > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean deleteStudent(Integer studentId) {
		int deletCount = studentDao.deleteStudent(studentId);
		if (deletCount > 0) {
			return true;
		} else {
			return false;
		}
	}
}
