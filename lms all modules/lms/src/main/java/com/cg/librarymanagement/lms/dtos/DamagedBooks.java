package com.cg.librarymanagement.lms.dtos;

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
@Table(name="damagedbooks_details")
public class DamagedBooks {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	@Column
	private int quantity;
	@NotNull(message = "description is required")
	@Pattern(regexp= "^[A-Za-z]{3,}$")
	@Column(name="description")
	private String description;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bookid")
	private Book book;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public DamagedBooks() {
		super();
	}
	public DamagedBooks(Book book, int quantity, String description) {
		super();
		this.book = book;
		this.quantity = quantity;
		this.description = description;
	}
	public DamagedBooks(int id, Book book, int quantity, String description) {
		super();
		this.id = id;
		this.book = book;
		this.quantity = quantity;
		this.description = description;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DamagedBooks [id=");
		builder.append(id);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append(", description=");
		builder.append(description);
		builder.append("]");
		return builder.toString();
	}
	


}
