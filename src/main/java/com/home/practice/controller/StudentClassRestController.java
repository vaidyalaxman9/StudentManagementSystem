package com.home.practice.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.home.practice.bo.StudentClassBo;
import com.home.practice.pojo.StudentClass;
import com.home.practice.response.StandardResponse;

@RestController
@RequestMapping("/studentclass-service")

public class StudentClassRestController {

	@Autowired
	StudentClassBo studentclassBo;

	@GetMapping(value = "/studentclass", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<StudentClass> getAllStudentClass() {
		return studentclassBo.getAllStudentClass();
	}

	@PostMapping(value = "/studentclass", produces = MediaType.APPLICATION_JSON_VALUE)
	public StandardResponse saveStudentClass(@RequestBody String studentclassData) {
		JSONObject studentclassJson = new JSONObject(studentclassData);
		boolean saveStatus = studentclassBo.addStudentClass(studentclassJson.getString("className"),
				studentclassJson.getString("notes"));
		if (saveStatus)
			return new StandardResponse(true, "Student class details saved successfully!");
		else
			return new StandardResponse(false, "Error while saving student class details!");
	}

	@PutMapping(value = "/studentclass", produces = MediaType.APPLICATION_JSON_VALUE)
	public StandardResponse updateStudentClass(@RequestBody String studentclassData) {
		JSONObject studentclassJson = new JSONObject(studentclassData);
		boolean updateStatus = studentclassBo.updateStudentClass(studentclassJson.getString("className"),
				studentclassJson.getString("notes"), studentclassJson.getInt("classId"));
		if (updateStatus)
			return new StandardResponse(true, "Student class details updated successfully!");
		else
			return new StandardResponse(false, "Error while updating student class details!");
	}

	// Employee Id in URL
	@DeleteMapping(value = "/studentclass/{classId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public StandardResponse deleteStudentClassByUrlStudentClassId(@PathVariable(value = "classId") int classId) {
		boolean deleteStatus = studentclassBo.deleteStudentClass(classId);
		if (deleteStatus)
			return new StandardResponse(true, "Student class details deleted successfully!");
		else
			return new StandardResponse(false, "Error while deleting student class details!");
	}
}
