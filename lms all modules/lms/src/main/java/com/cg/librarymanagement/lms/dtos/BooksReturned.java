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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;




@Entity
public class BooksReturned {
	@Id
	@GeneratedValue
	private Long returnid;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_fk")
	private User user;
	//@OneToMany(mappedBy="booksReturned" ,cascade=CascadeType.ALL,fetch= FetchType.LAZY) 
	@OneToMany(targetEntity=Book.class,cascade=CascadeType.ALL)
	@JoinColumn(name="brs_fk",referencedColumnName="returnid")
	private List<Book> books;
	@NotNull(message="Date should not be null")
	@Temporal(TemporalType.DATE)
	private Date returnedDate;
	private int delayed_Days;
	private double penalty;
	private String penalty_Status;
	private List<Book> book;
	public BooksReturned() {
		super();
	}
	
	public BooksReturned( User users, List<Book> book, Date returnedDate, int delayed_Days, double penalty,
			String penalty_Status) {
		super();
		this.user = users;
		this.book = book;
		this.returnedDate = returnedDate;
		this.delayed_Days = delayed_Days;
		this.penalty = penalty;
		this.penalty_Status = penalty_Status;
	}

	
	public Long getReturnid() {
		return returnid;
	}
	public void setReturnid(Long returnid) {
		this.returnid = returnid;
	}

	public User getUsers() {
		return user;
	}
	
	public void setUsers(User user) {
		this.user = user;
	}
	
	public List<Book> getBook() {
		return book;
	}
	
	public void setBooks(List<Book> book) {
		this.book = book;
	}
	
	public Date getReturnedDate() {
		return returnedDate;
	}
	
	public void setReturnedDate(Date returnedDate) {
		this.returnedDate = returnedDate;
	}
	
	public int getDelayed_Days() {
		return delayed_Days;
	}
	
	public void setDelayed_Days(int delayed_Days) {
		this.delayed_Days = delayed_Days;
	}
	
	public double getPenalty() {
		return penalty;
	}
	
	public void setPenalty(double penalty) {
		this.penalty = penalty;
	}
	
	public String getPenalty_Status() {
		return penalty_Status;
	}
	
	public void setPenalty_Status(String penalty_Status) {
		this.penalty_Status = penalty_Status;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BooksReturned [id=" + returnid + ", user=" + user + ", books=" + books + ", returnedDate=" + returnedDate
				+ ", delayed_Days=" + delayed_Days + ", penalty=" + penalty + ", penalty_Status=" + penalty_Status
				+ "]";
	}
	}