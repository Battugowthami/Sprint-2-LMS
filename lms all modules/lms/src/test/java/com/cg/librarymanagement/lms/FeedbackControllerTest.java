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
import org.springframework.test.web.servlet.MockMvc;

import com.cg.librarymanagement.lms.controller.FeedbackController;
import com.cg.librarymanagement.lms.dtos.Feedback;
import com.cg.librarymanagement.lms.service.FeedbackService;






@ExtendWith(MockitoExtension.class)
public class FeedbackControllerTest {
	private MockMvc mockMvc;
	@Mock
    FeedbackService feedbackservice;
	@InjectMocks
	FeedbackController feedbackcontroller;

	@Test
	public void testwriteFeedback() {
		
		Feedback feedback=new Feedback();
		        Mockito.when(feedbackcontroller.writeFeedback(feedback)).thenReturn(feedback);
		        assertEquals(feedback,feedbackcontroller.writeFeedback(feedback));
		    }
	
	 @Test
	 public void testviewFeedBackByUser() {
		 Feedback feedback=new Feedback();
		 int userid=1;
		 Mockito.when(feedbackcontroller.viewFeedBackByUser(userid)).thenReturn(feedback);
	        assertEquals(feedback,feedbackcontroller.viewFeedBackByUser(userid));

	 }
	 
	 @Test
		public void testupdateFeedback() {
			
			Feedback feedback=new Feedback();;
			        int id=1;
					Mockito.when(feedbackcontroller.updateFeedback(id,feedback)).thenReturn(feedback);
			         assertEquals(feedback,feedbackcontroller.updateFeedback(id, feedback));
			    }
	 
	 @Test
	 public void testviewFeedbackList() {
		 List<Feedback> feedback=new ArrayList<Feedback>();
	       Mockito.when(feedbackcontroller.viewFeedbackList()).thenReturn(feedback);
	        assertEquals(feedback,feedbackcontroller.viewFeedbackList());
	 }
	
	
}

