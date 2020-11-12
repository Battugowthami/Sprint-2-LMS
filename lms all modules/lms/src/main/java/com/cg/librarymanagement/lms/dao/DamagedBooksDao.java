package com.cg.librarymanagement.lms.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.librarymanagement.lms.dtos.DamagedBooks;



@Repository
public interface DamagedBooksDao extends JpaRepository<DamagedBooks,Integer>{
	
	List<DamagedBooks> findAll();
	void deleteById(int id);

}

