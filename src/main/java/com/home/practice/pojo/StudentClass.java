package com.home.practice.pojo;

public class StudentClass {

	public int classId;
	public String className;
	public String notes;
	
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	public StudentClass(int classId, String className, String notes) {
		super();
		this.classId = classId;
		this.className = className;
		this.notes = notes;
	}
		
	public StudentClass() {
		super();
	}
}
