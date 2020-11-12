package com.cg.librarymanagement.lms.dtos;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


//import org.hibernate.annotations.CreationTimestamp;
@Entity
@Table(name="feedback_details")
public class Feedback {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	

	@NotNull(message = "Date Should not be null.")
	@Column(name="feedbackDate")
    private Date feedbackDate;
    
    @NotNull(message = "description required")
	@Pattern(regexp= "^[A-Za-z]{3,}$")
	@Column(name="description")
	private String description;
    
    @NotNull(message = "rating required")
	@Pattern(regexp= "^[A-Za-z]{3,}$")
	@Column(name="rating")
	private String rating;
    
    @NotNull(message = "comments required")
	@Pattern(regexp= "^[A-Za-z]{3,}$")
	@Column(name="comments")
	private String comments;
    
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="userid")
	private User user;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getFeedbackDate() {
		return feedbackDate;
	}
	public void setFeedbackDate(Date feedbackDate) {
		this.feedbackDate = feedbackDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Feedback() {
		super();
	}
	public Feedback(User user, Date feedbackDate, String description, String rating, String comments) {
		super();
		this.user = user;
		this.feedbackDate = feedbackDate;
		this.description = description;
		this.rating = rating;
		this.comments = comments;
	}
	public Feedback(int id, User user, Date feedbackDate, String description, String rating, String comments) {
		super();
		this.id = id;
		this.user = user;
		this.feedbackDate = feedbackDate;
		this.description = description;
		this.rating = rating;
		this.comments = comments;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Feedback [id=");
		builder.append(id);
		builder.append(", user=");
		builder.append(user);
		builder.append(", feedbackDate=");
		builder.append(feedbackDate);
		builder.append(", description=");
		builder.append(description);
		builder.append(", rating=");
		builder.append(rating);
		builder.append(", comments=");
		builder.append(comments);
		builder.append("]");
		return builder.toString();
	}
	
}

