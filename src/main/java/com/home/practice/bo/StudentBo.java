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

}
