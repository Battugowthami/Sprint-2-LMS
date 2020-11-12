package com.cg.librarymanagement.lms.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cg.librarymanagement.lms.dtos.DamagedBooks;
import com.cg.librarymanagement.lms.service.DamagedBooksService;


@Controller
@Validated
@RequestMapping("/damagedbooks")
public class DamagedBooksController {
	Logger log = LoggerFactory.getLogger(DamagedBooksController.class);
	
	@Autowired
	private DamagedBooksService damagedbooksservice;
		
	@GetMapping(value = {"/" })
	public @ResponseBody List<DamagedBooks> viewDamagedBooksList() 
	{ 
		List<DamagedBooks> damagedbooks = damagedbooksservice.viewDamagedBooksList();
		return damagedbooks;
	}

	@GetMapping("/{id}")
	public @ResponseBody  DamagedBooks viewDamagedBooksById(@PathVariable int id) 
	{
		return damagedbooksservice.viewDamagedBooksById(id);
	}

	@PostMapping("/")
	public @ResponseBody DamagedBooks addDamagedBooks(@Valid @RequestBody DamagedBooks damagedbooks)
	{
		return damagedbooksservice.addDamagedBooks(damagedbooks);
	}

	@PutMapping("/{id}")
	public @ResponseBody DamagedBooks updateDamagedBooks(@PathVariable int id,@RequestBody DamagedBooks damagedbooks) 
	{
		return damagedbooksservice.updateDamagedBooksDetails(id, damagedbooks);
	}

}


