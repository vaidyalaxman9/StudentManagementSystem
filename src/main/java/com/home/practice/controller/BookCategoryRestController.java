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

import com.home.practice.bo.BookCategoryBo;
import com.home.practice.pojo.BookCategory;
import com.home.practice.response.StandardResponse;

@RestController
@RequestMapping("/bookcategory-service")

public class BookCategoryRestController {

	@Autowired
	BookCategoryBo bookcategoryBo;

	@GetMapping(value = "/bookcategory", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<BookCategory> getAllBookCategory() {
		return bookcategoryBo.getAllBookCategory();
	}

	@PostMapping(value = "/bookcategory", produces = MediaType.APPLICATION_JSON_VALUE)
	public StandardResponse saveBookCategory(@RequestBody String bookcategoryData) {
		JSONObject bookcategoryJson = new JSONObject(bookcategoryData);
		boolean saveStatus = bookcategoryBo.addBookCategory(bookcategoryJson.getString("categoryName"),
				bookcategoryJson.getString("categoryDescription"));
		if (saveStatus)
			return new StandardResponse(true, "Book Category details saved successfully!");
		else
			return new StandardResponse(false, "Error while saving book category details!");
	}

	@PutMapping(value = "/bookcategory", produces = MediaType.APPLICATION_JSON_VALUE)
	public StandardResponse updateBookCategory(@RequestBody String bookcategoryData) {
		JSONObject bookcategoryJson = new JSONObject(bookcategoryData);
		boolean updateStatus = bookcategoryBo.updateBookCategory(bookcategoryJson.getString("categoryName"),
				bookcategoryJson.getString("categoryDescription"), bookcategoryJson.getInt("bookCategoryId"));
		if (updateStatus)
			return new StandardResponse(true, "Book Category details updated successfully!");
		else
			return new StandardResponse(false, "Error while updating book category details!");
	}

	// Employee Id in URL
	@DeleteMapping(value = "/bookcategory/{bookCategoryId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public StandardResponse deleteBookCategoryByUrlBookCategoryId(
			@PathVariable(value = "bookCategoryId") int bookCategoryId) {
		boolean deleteStatus = bookcategoryBo.deleteBookCategory(bookCategoryId);
		if (deleteStatus)
			return new StandardResponse(true, "Book Category details deleted successfully!");
		else
			return new StandardResponse(false, "Error while deleting book category details!");
	}

}