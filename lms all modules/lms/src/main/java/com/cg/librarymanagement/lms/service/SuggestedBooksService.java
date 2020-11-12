package com.cg.librarymanagement.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.librarymanagement.lms.dao.SuggestedBooksDao;
import com.cg.librarymanagement.lms.dtos.SuggestedBooks;
import com.cg.librarymanagement.lms.exception.BookNotFoundException;

@Service
public class SuggestedBooksService {
	@Autowired
	private SuggestedBooksDao suggestedbooksdao;
	
	public List<SuggestedBooks> viewSuggestedBooksList() {
		System.out.println("SuggestedBooks...");
		return suggestedbooksdao.findAll();
	}
	
	public SuggestedBooks viewSuggestedBookDetails(int id) 
	{
		System.out.println("SuggestedBook");
		Optional<SuggestedBooks>optional=suggestedbooksdao.findById(id);
		if(!optional.isPresent()) {
			throw new BookNotFoundException("Damaged book not found for id="+id);
		}
		else
			return optional.get();
}
	
	public SuggestedBooks addSuggestedBooks(SuggestedBooks suggestedbooks)
	{
			System.out.println("Book added.");
			return suggestedbooksdao.save(suggestedbooks);
	}
	
	public SuggestedBooks updateSuggestedBooksDetails(int id,SuggestedBooks suggestedbooks)
	{
		System.out.println("SuggestedBooks updated");

		Optional<SuggestedBooks> repSuggestedBooks = suggestedbooksdao.findById(id);
		if(!repSuggestedBooks.isPresent()) {
			throw new BookNotFoundException("Damaged book not found for id="+id);
		}
		else
		{
			SuggestedBooks suggestedbooksToBeUpdated = repSuggestedBooks.get();
			
			//suggestedbooksToBeUpdated.setId(suggestedbooks.getId());
			suggestedbooksToBeUpdated.setUsers(suggestedbooks.getUsers());
			suggestedbooksToBeUpdated.setTitle(suggestedbooks.getTitle());
			suggestedbooksToBeUpdated.setSubject(suggestedbooks.getSubject());
			suggestedbooksToBeUpdated.setAuthor(suggestedbooks.getAuthor());
			suggestedbooksToBeUpdated.setPublications(suggestedbooks.getPublications());
			suggestedbooksToBeUpdated.setDescription(suggestedbooks.getDescription());
			suggestedbooksToBeUpdated.setSuggested_date(suggestedbooks.getSuggested_date());
			suggestedbooksToBeUpdated.setStatus(suggestedbooks.getStatus());
			return suggestedbooksdao.save(suggestedbooksToBeUpdated);

		}
          
	}
	public SuggestedBooks removeSuggestedBooks(int id) {
		System.out.println("SuggestedBook removed.");
			Optional<SuggestedBooks>optional=suggestedbooksdao.findById(id);
			if(!optional.isPresent()) {
				throw new BookNotFoundException("suggested book not found for id="+id);
			}
			else
				suggestedbooksdao.deleteById(id);
				return null;
		}
		

}

