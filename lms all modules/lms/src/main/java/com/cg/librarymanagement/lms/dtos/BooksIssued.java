package com.cg.librarymanagement.lms.dtos;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;



@Entity
@Table
public class BooksIssued {
	@Id
	@GeneratedValue
	private Long issueId;
	@NotNull(message="Date should not be null")
	@Temporal(TemporalType.DATE)
	private Date issueDate;
	private int quantity;
	@NotNull(message="Date should not be null")
	@Temporal(TemporalType.DATE)
	private Date dueDate;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_fk")
	private User user;
	
	//@OneToMany(mappedBy="booksIssued",cascade=CascadeType.ALL,fetch= FetchType.LAZY)
	@OneToMany(targetEntity=Book.class,cascade=CascadeType.ALL)
	@JoinColumn(name="bis_fk",referencedColumnName="issueId")
	private List<Book> books;
	
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public BooksIssued() {
		super();
	}
	public BooksIssued(User user, Date issueDate, int quantity, Date dueDate, List<Book> books) {
		super();
		this.user = user;
		this.issueDate = issueDate;
		this.quantity = quantity;
		this.dueDate = dueDate;
		this.books = books;
	}

	public Long getIssueId() {
		return issueId;
	}
	
	public void setIssueId(Long issueId) {
		this.issueId = issueId;
	}
	
	public User getUsers() {
		return user;
	}
	
	public void setUsers(User user) {
		this.user = user;
	}
	
	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	@Override
	public String toString() {
		return "BooksIssued [issueId=" + issueId + ", users=" + user + ", issueDate=" + issueDate + ", quantity="
				+ quantity + ", dueDate=" + dueDate + ", books=" + books + "]";
	}
	
	
	}
