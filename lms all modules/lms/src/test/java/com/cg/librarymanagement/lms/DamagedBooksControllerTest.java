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
import com.cg.librarymanagement.lms.controller.DamagedBooksController;
import com.cg.librarymanagement.lms.dtos.DamagedBooks;
import com.cg.librarymanagement.lms.service.DamagedBooksService;


	@ExtendWith(MockitoExtension.class)
	public class DamagedBooksControllerTest {
		//private MockMvc mockMvc;
		@Mock
	    DamagedBooksService damagedbooksservice;
		@InjectMocks
		DamagedBooksController damagedbookscontroller;

		@Test
		public void testaddDamagedBooks() {
			
			DamagedBooks damagedbooks=new DamagedBooks();
			        Mockito.when(damagedbookscontroller.addDamagedBooks(damagedbooks)).thenReturn(damagedbooks);
			        assertEquals(damagedbooks,damagedbookscontroller.addDamagedBooks(damagedbooks));
			    }
		
		 @Test
		 public void testviewDamagedBooksById() {
			 DamagedBooks damagedbooks=new DamagedBooks();
			 int id=1;
			 Mockito.when(damagedbookscontroller.viewDamagedBooksById(id)).thenReturn(damagedbooks);
		        assertEquals(damagedbooks,damagedbookscontroller.viewDamagedBooksById(id));

		 }
		 
		 @Test
			public void testupdateDamagedBooks() {
				
				DamagedBooks damagedbooks=new DamagedBooks();
				        Mockito.when(damagedbookscontroller.addDamagedBooks(damagedbooks)).thenReturn(damagedbooks);
				        assertEquals(damagedbooks,damagedbookscontroller.addDamagedBooks(damagedbooks));
				    }
		 
		 @Test
		 public void testviewDamagedBooksList() {
			 List<DamagedBooks> damagedbooks=new ArrayList<DamagedBooks>();
		       Mockito.when(damagedbookscontroller.viewDamagedBooksList()).thenReturn(damagedbooks);
		        assertEquals(damagedbooks,damagedbookscontroller.viewDamagedBooksList());
		 }
		
		


	}

