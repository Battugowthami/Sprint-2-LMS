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
@Entity
@Table(name="suggestedbooks_details")
public class SuggestedBooks {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	@NotNull(message = "title is required")
	@Pattern(regexp= "^[A-Za-z]{3,}$")
	@Column
	private String title;
	@NotNull(message = "subject is required")
	@Pattern(regexp= "^[A-Za-z]{3,}$")
	@Column
	private String subject;
	@NotNull(message = "author is required")
	@Pattern(regexp= "^[A-Za-z]{3,}$")
	@Column
	private String author;
	@NotNull(message = "publications is required")
	@Pattern(regexp= "^[A-Za-z]{3,}$")
	@Column
	private String publications;
	@NotNull(message = "description is required")
	@Pattern(regexp= "^[A-Za-z]{3,}$")
	@Column
	private String description;
	@NotNull(message="Date Should not be null.")
	@Column
	private Date suggested_date;
	@NotNull(message = "status is required")
	@Pattern(regexp= "^[A-Za-z]{3,}$")
	@Column
	private String status;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userid")
	private User users;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUsers() {
		return users;
	}
	public void setUsers(User users) {
		this.users = users;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublications() {
		return publications;
	}
	public void setPublications(String publications) {
		this.publications = publications;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getSuggested_date() {
		return suggested_date;
	}
	public void setSuggested_date(Date suggested_date) {
		this.suggested_date = suggested_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public SuggestedBooks() {
		super();
	}
	public SuggestedBooks(User users, String title, String subject, String author, String publications,
			String description, Date suggested_date, String status) {
		super();
		this.users = users;
		this.title = title;
		this.subject = subject;
		this.author = author;
		this.publications = publications;
		this.description = description;
		this.suggested_date = suggested_date;
		this.status = status;
	}
	public SuggestedBooks(int id, User users, String title, String subject, String author, String publications,
			String description, Date suggested_date, String status) {
		super();
		this.id = id;
		this.users = users;
		this.title = title;
		this.subject = subject;
		this.author = author;
		this.publications = publications;
		this.description = description;
		this.suggested_date = suggested_date;
		this.status = status;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SuggestedBooks [id=");
		builder.append(id);
		builder.append(", title=");
		builder.append(title);
		builder.append(", subject=");
		builder.append(subject);
		builder.append(", author=");
		builder.append(author);
		builder.append(", publications=");
		builder.append(publications);
		builder.append(", description=");
		builder.append(description);
		builder.append(", suggested_date=");
		builder.append(suggested_date);
		builder.append(", status=");
		builder.append(status);
		builder.append("]");
		return builder.toString();
	}
	
	
	

}

