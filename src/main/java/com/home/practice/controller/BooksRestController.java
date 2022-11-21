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

import com.home.practice.bo.BooksBo;
import com.home.practice.pojo.Books;
import com.home.practice.response.StandardResponse;

@RestController
@RequestMapping("/books-service")

public class BooksRestController {

	@Autowired
	BooksBo booksBo;

	@GetMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Books> getAllBooks() {
		return booksBo.getAllBooks();
	}

	@PostMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
	public StandardResponse saveBooks(@RequestBody String booksData) {
		JSONObject booksJson = new JSONObject(booksData);
		boolean saveStatus = booksBo.addBooks(booksJson.getString("bookName"), booksJson.getInt("className"));
		if (saveStatus)
			return new StandardResponse(true, "Books details saved successfully!");
		else
			return new StandardResponse(false, "Error while saving books  details!");
	}

	@PutMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
	public StandardResponse updateBooks(@RequestBody String booksData) {
		JSONObject booksJson = new JSONObject(booksData);
		boolean updateStatus = booksBo.updateBooks(booksJson.getString("bookName"), booksJson.getInt("className"),
				booksJson.getInt("bookId"));
		if (updateStatus)
			return new StandardResponse(true, "Books details updated successfully!");
		else
			return new StandardResponse(false, "Error while updating books details!");
	}

	// Employee Id in URL
	@DeleteMapping(value = "/books/{bookId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public StandardResponse deleteBooksByUrlBooksId(@PathVariable(value = "bookId") int bookId) {
		boolean deleteStatus = booksBo.deleteBooks(bookId);
		if (deleteStatus)
			return new StandardResponse(true, "Books details deleted successfully!");
		else
			return new StandardResponse(false, "Error while deleting books details!");
	}
}