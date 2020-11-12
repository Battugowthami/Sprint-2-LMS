package com.cg.librarymanagement.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.librarymanagement.lms.dao.BooksReturnedDao;
import com.cg.librarymanagement.lms.dtos.BooksReturned;
import com.cg.librarymanagement.lms.exception.BookNotFoundException;


@Service
public class BooksReturnedService {
	@Autowired
	private BooksReturnedDao booksReturnedDao;
	
	public BooksReturned addreturnBooks(BooksReturned returned) {
		return booksReturnedDao.save(returned);
		
	}
	public BooksReturned updateReturnedBookDetails(Long id,BooksReturned booksReturned)
	{
		Optional<BooksReturned > repBooksReturned = booksReturnedDao.findById(id);

		if (!repBooksReturned.isPresent()) {
			throw new BookNotFoundException("Book not found for id "+id);}else{

			BooksReturned returnedToBeUpdated = repBooksReturned.get();
			
			returnedToBeUpdated.setBooks(booksReturned.getBook());
			returnedToBeUpdated.setUsers(booksReturned.getUsers());
			returnedToBeUpdated.setReturnedDate(booksReturned.getReturnedDate());
			returnedToBeUpdated.setDelayed_Days(booksReturned.getDelayed_Days());
			returnedToBeUpdated.setPenalty_Status(booksReturned.getPenalty_Status());
			return booksReturnedDao.save(returnedToBeUpdated);
		}
	}
	public List<BooksReturned> viewReturnedBooksList(){
		return booksReturnedDao.findAll();
	}
	/*public List<BooksReturned> viewDelayedBooksList(){
		return booksReturnedDao.viewDelayedBooksList();
		//return booksReturnedDao.findAll();
		
	}*/}
	
	


