package com.cg.librarymanagement.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.librarymanagement.lms.dao.DamagedBooksDao;
import com.cg.librarymanagement.lms.dtos.DamagedBooks;
import com.cg.librarymanagement.lms.exception.BookNotFoundException;


@Service
public class DamagedBooksService {
	@Autowired
	private DamagedBooksDao damagedbooksdao;
	
	public List<DamagedBooks> viewDamagedBooksList() {
		System.out.println("DamagedBooks...");
		return damagedbooksdao.findAll();
	}
	
	public DamagedBooks viewDamagedBooksById(int id) 
	{
		System.out.println("DamagedBook");
			Optional<DamagedBooks>optional=damagedbooksdao.findById(id);
			if(!optional.isPresent()) {
				throw new BookNotFoundException("Damaged book not found for id="+id);
			}
			else
				return optional.get();
	}

	
	
	public DamagedBooks addDamagedBooks(DamagedBooks damagedbooks)
	{
			System.out.println("Book added.");
			return damagedbooksdao.save(damagedbooks);
	}
	
	public DamagedBooks updateDamagedBooksDetails(int id,DamagedBooks damagedbooks)
	{
		System.out.println("DamagedBooks updated");
		
		Optional<DamagedBooks> repDamagedBooks = damagedbooksdao.findById(id);
		if(!repDamagedBooks.isPresent()) {
			throw new BookNotFoundException("Damaged book not found for id="+id);
		}
		else
		{

			DamagedBooks damagedbooksToBeUpdated = repDamagedBooks.get();
			
			//damagedbooksToBeUpdated.setId(damagedbooks.getId());
			damagedbooksToBeUpdated.setBook(damagedbooks.getBook());
			damagedbooksToBeUpdated.setQuantity(damagedbooks.getQuantity());
			damagedbooksToBeUpdated.setDescription(damagedbooks.getDescription());
			return damagedbooksdao.save(damagedbooksToBeUpdated);

		}
	}
}
	

	
