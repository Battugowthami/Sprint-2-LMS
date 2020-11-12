package com.cg.librarymanagement.lms;

import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;

import com.cg.librarymanagement.lms.controller.PublisherController;
import com.cg.librarymanagement.lms.dtos.Publishers;
import com.cg.librarymanagement.lms.service.PublisherService;






@ExtendWith(MockitoExtension.class)
public class PublisherControllerTest {
	private MockMvc mockMvc;
	@Mock
    PublisherService publisherservice;
	@InjectMocks
	PublisherController publishercontroller;

	@Test
	public void testaddPublisher() {
		
		       Publishers publisher=new Publishers();
		        Mockito.when(publishercontroller.addPublisher(publisher)).thenReturn(publisher);
		        assertEquals(publisher,publishercontroller.addPublisher(publisher));
		    }
	
	@Test
	public void testupdatePublisherDetails() {
		
		Publishers publisher=new Publishers();
		int id=1;
		Mockito.when(publishercontroller.updatePublisherDetails(id,publisher)).thenReturn(publisher);
         assertEquals(publisher,publishercontroller.updatePublisherDetails(id, publisher));
		    }
	
	 @Test
	 public void testviewPublisherById() {
		 Publishers publisher=new Publishers();
		 int publisherId=1;
		 Mockito.when(publishercontroller.viewPublisherById(publisherId)).thenReturn(publisher);
	        assertEquals(publisher,publishercontroller.viewPublisherById(publisherId));

		 
	 }
	 
	 @Test
	 public void testviewPublishersList() {
		 List<Publishers> publisher=new ArrayList<Publishers>();
	       Mockito.when(publishercontroller.viewPublishersList()).thenReturn(publisher);
	        assertEquals(publisher,publishercontroller.viewPublishersList());
	 }
	
	 @Test
		public void testremovePublisher() {
			     Publishers publisher=new Publishers();
			
			    int publisherId =1;;
			    
				Mockito.when(publishercontroller.removePublisher(publisherId)).thenReturn(publisher);
			        assertEquals(publisher,publishercontroller.removePublisher(publisherId));
			  }


	
}
