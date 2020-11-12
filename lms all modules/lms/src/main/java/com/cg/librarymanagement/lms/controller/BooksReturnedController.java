package com.cg.librarymanagement.lms.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cg.librarymanagement.lms.dtos.BooksReturned;
import com.cg.librarymanagement.lms.service.BooksReturnedService;


@Controller
@RequestMapping("/booksreturned")
public class BooksReturnedController {
	
	
	@Autowired
	private BooksReturnedService  booksReturnedService;
	
	@PostMapping("/")
	public @ResponseBody BooksReturned addreturnBooks(@RequestBody BooksReturned returned) {
		return booksReturnedService.addreturnBooks(returned);
	}
	
	@PutMapping("/{returnid}")
	public @ResponseBody BooksReturned updateReturnedBookDetails(@PathVariable Long returnid,@RequestBody BooksReturned booksReturned) {
		return booksReturnedService.updateReturnedBookDetails(returnid, booksReturned);
	}
	@GetMapping(value = {"/" })
	public @ResponseBody List<BooksReturned> viewReturnedBooksList(){
		return booksReturnedService.viewReturnedBooksList();
	}
	/*@GetMapping(value = {"/" })
	public @ResponseBody List<BooksReturned> viewDelayedBooksList(){
		return booksReturnedService.viewDelayedBooksList();
	}*/
}
