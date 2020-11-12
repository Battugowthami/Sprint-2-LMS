package com.cg.librarymanagement.lms;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.librarymanagement.lms.controller.SuggestedBooksController;
import com.cg.librarymanagement.lms.dtos.SuggestedBooks;
import com.cg.librarymanagement.lms.service.SuggestedBooksService;


@ExtendWith(MockitoExtension.class)
public class SuggestedBooksControllerTest {
	//private MockMvc mockMvc;
	@Mock
    SuggestedBooksService suggestedbooksservice;
	@InjectMocks
	SuggestedBooksController suggestedbookscontroller;

	@Test
	public void testaddSuggestedBooks() {
		
		SuggestedBooks suggestedbooks=new SuggestedBooks();
		        Mockito.when(suggestedbookscontroller.addSuggestedBooks(suggestedbooks)).thenReturn(suggestedbooks);
		        assertEquals(suggestedbooks,suggestedbookscontroller.addSuggestedBooks(suggestedbooks));
		    }
	
	 @Test
	 public void testviewSuggestedBooksDetails() {
		 SuggestedBooks suggestedbooks=new SuggestedBooks();
		 int id=1;
		 Mockito.when(suggestedbookscontroller.viewSuggestedBookDetails(id)).thenReturn(suggestedbooks);
	        assertEquals(suggestedbooks,suggestedbookscontroller.viewSuggestedBookDetails(id));

	 }
	 
	 @Test
		public void testupdateSuggestedBooks() {
			
			SuggestedBooks suggestedbooks=new SuggestedBooks();
			        Mockito.when(suggestedbookscontroller.addSuggestedBooks(suggestedbooks)).thenReturn(suggestedbooks);
			        assertEquals(suggestedbooks,suggestedbookscontroller.addSuggestedBooks(suggestedbooks));
			    }
	 
	 @Test
	 public void testviewSuggestedBooksList() {
		 List<SuggestedBooks> suggestedbooks=new ArrayList<SuggestedBooks>();
	       Mockito.when(suggestedbookscontroller.viewSuggestedBooksList()).thenReturn(suggestedbooks);
	        assertEquals(suggestedbooks,suggestedbookscontroller.viewSuggestedBooksList());
	 }
	 
	 @Test
	 public void testremoveSuggestedBooks() {
		 SuggestedBooks suggestedbooks=new SuggestedBooks();
	        int id=1;
			Mockito.when(suggestedbookscontroller.removeSuggestedBooks(id)).thenReturn(suggestedbooks);
	        assertEquals(suggestedbooks,suggestedbookscontroller.removeSuggestedBooks(id));
		 
	 }
	 

}

