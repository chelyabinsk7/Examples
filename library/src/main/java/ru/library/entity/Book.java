package ru.library.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "book")
public class Book {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "author_name")
	private String author_name;
	
	@Column(name = "book_name")
	private String book_name;
	
	@Column(name = "date_create")
	@JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate date_create;
	
	@Column(name = "access_type")
	@Enumerated(EnumType.STRING)
	private Access_type access_type;

	public Book() {
	}

	public Book(Integer id, String author_name, String book_name, LocalDate date_create, Access_type access_type) {
		this.id = id;
		this.author_name = author_name;
		this.book_name = book_name;
		this.date_create = date_create;
		this.access_type = access_type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAuthor_name() {
		return author_name;
	}

	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public LocalDate getDate_create() {
		return date_create;
	}

	public void setDate_create(LocalDate date_create) {
		this.date_create = date_create;
	}

	public Access_type getAccess_type() {
		return access_type;
	}

	public void setAccess_type(Access_type access_type) {
		this.access_type = access_type;
	}


}
