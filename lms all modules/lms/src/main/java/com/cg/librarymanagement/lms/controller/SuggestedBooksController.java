package com.cg.librarymanagement.lms.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cg.librarymanagement.lms.dtos.SuggestedBooks;
import com.cg.librarymanagement.lms.service.SuggestedBooksService;


@Controller
@Validated
@RequestMapping("/suggestedbooks")
public class SuggestedBooksController {
	Logger log = LoggerFactory.getLogger(SuggestedBooksController.class);
	
	@Autowired
	private SuggestedBooksService suggestedbooksservice;
		
	@GetMapping(value = {"/" })
	public @ResponseBody List<SuggestedBooks> viewSuggestedBooksList() 
	{ 
		List<SuggestedBooks> suggestedbooks = suggestedbooksservice.viewSuggestedBooksList();
		return suggestedbooks;
	}

	@GetMapping("/{id}")
	public @ResponseBody  SuggestedBooks viewSuggestedBookDetails(@PathVariable int id) 
	{
		return suggestedbooksservice.viewSuggestedBookDetails(id);
	}

	@PostMapping("/")
	public @ResponseBody SuggestedBooks addSuggestedBooks(@Valid @RequestBody SuggestedBooks suggestedbooks) 
	{
		return suggestedbooksservice.addSuggestedBooks(suggestedbooks);
	}

	@PutMapping("/{id}")
	public @ResponseBody SuggestedBooks updateSuggestedBooks(@PathVariable int id,@RequestBody SuggestedBooks suggestedbooks) 
	{
		return suggestedbooksservice.updateSuggestedBooksDetails(id, suggestedbooks);
	}

	@DeleteMapping("/{id}")
	public @ResponseBody SuggestedBooks removeSuggestedBooks(@PathVariable int id) 
	{
		return suggestedbooksservice.removeSuggestedBooks(id);
	}


}
