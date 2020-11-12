package com.cg.librarymanagement.lms.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cg.librarymanagement.lms.dtos.BooksIssued;
import com.cg.librarymanagement.lms.exception.BookNotFoundException;
import com.cg.librarymanagement.lms.service.BooksIssuedService;
@Controller
@RequestMapping("/booksissued")
public class BooksIssuedController {
@Autowired
private BooksIssuedService booksIssuedService;
	
@GetMapping(value = {"/" })
public @ResponseBody List<BooksIssued> getAllBooksIssued() 
{ 
	List<BooksIssued> booksIssued = booksIssuedService.getAllbooksIssued();
	return booksIssued;
}

@GetMapping("/{issueId}")
public @ResponseBody  BooksIssued getBooksIssuedById(@PathVariable Long issueId) 
{
	return booksIssuedService.getBooksIssuedById(issueId);
}

@PostMapping("/")
public @ResponseBody BooksIssued addBooksIssued(@RequestBody BooksIssued booksIssued) 
{
	return booksIssuedService.addBooksIssued(booksIssued);
}

@PutMapping("/{issueId}")
public @ResponseBody BooksIssued updateBooksIssued(@PathVariable Long issueId,@RequestBody BooksIssued booksIssued)  
{
	return booksIssuedService.updateBooksIssued(issueId, booksIssued);
}

@DeleteMapping("/{issueId}")
public @ResponseBody String removeBook(@PathVariable Long issueId) throws BookNotFoundException 
{
  return booksIssuedService.removeBoksIssuedById(issueId);
}
}

