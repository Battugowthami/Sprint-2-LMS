package com.cg.librarymanagement.lms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.librarymanagement.lms.dtos.SuggestedBooks;



@Repository
public interface SuggestedBooksDao extends JpaRepository<SuggestedBooks,Integer>{
	
	List<SuggestedBooks> findAll();
	void deleteById(int id);

	
}
