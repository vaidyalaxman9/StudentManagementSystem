package com.home.practice.pojo;

public class Student {

	public int studentId;
	public String stdName;
	public String mobile;
	public String address;
	public String notes;
	public String className;
	
	public Student(int studentId, String stdName, String mobile, String address, String notes, String className) {
		super();
		this.studentId = studentId;
		this.stdName = stdName;
		this.mobile = mobile;
		this.address = address;
		this.notes = notes;
		this.className = className;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
	public Student () {
		super();
	}
}
