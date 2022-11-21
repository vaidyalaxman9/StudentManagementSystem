package com.home.practice.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.practice.dao.StudentClassDao;
import com.home.practice.pojo.StudentClass;

@Service
public class StudentClassBo {

	@Autowired
	StudentClassDao studentclassDao;

	public List<StudentClass> getAllStudentClass() {
		return studentclassDao.getAllStudentClass();
	}

	public StudentClass getStudentClassData(Integer classId) {
		return studentclassDao.getStudentClassById(classId);
	}

	public List<StudentClass> addStudentClassInExistingList(List<StudentClass> studentclassList, int classId,
			String className, String notes) {
		StudentClass sc = new StudentClass(classId, className, notes);
		studentclassList.add(sc);
		return studentclassList;
	}

	public List<StudentClass> getStudentClassData() {
		return studentclassDao.fetchStudentClassData();
	}

	public boolean addStudentClass(String className, String notes) {
		int updateCount = studentclassDao.saveStudentClass(className, notes);
		if (updateCount > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean updateStudentClass(String className, String notes, int classId) {
		int updateCount = studentclassDao.updateStudentClass(className, notes, classId);
		if (updateCount > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean deleteStudentClass(Integer classId) {
		int deletCount = studentclassDao.deleteStudentClass(classId);
		if (deletCount > 0) {
			return true;
		} else {
			return false;
		}
	}
}
