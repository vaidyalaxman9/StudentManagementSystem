package com.home.practice.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.home.practice.bo.StudentBo;
import com.home.practice.pojo.Student;
import com.home.practice.response.StandardResponse;

@RestController
@RequestMapping("/student-service")

public class StudentRestController {

	@Autowired
	StudentBo studentBo;

	@GetMapping(value = "/student", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Student> getAllStudents() {
		return studentBo.getAllStudents();
	}

	@PostMapping(value = "/student", produces = MediaType.APPLICATION_JSON_VALUE)
	public StandardResponse saveStudent(@RequestBody String studentData) {
		JSONObject studentJson = new JSONObject(studentData);
		boolean saveStatus = studentBo.addStudent(studentJson.getString("stdName"), studentJson.getString("mobile"),
				studentJson.getString("address"), studentJson.getString("notes"), studentJson.getInt("className"));
		if (saveStatus)
			return new StandardResponse(true, "Student details saved successfully!");
		else
			return new StandardResponse(false, "Error while saving student details!");
	}
}
