/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Annotations.AuthorAnnotation;
import Entitys.AbstractBook;
import Entitys.Address;
import Entitys.Author;
import Entitys.ElectronicBook;
import Entitys.PaperBook;
import Services.Interfaces.IBookService;
import Services.Interfaces.IPersonService;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.convert.PersonConverter;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Florian
 */
@Named
@RequestScoped
@NoArgsConstructor
@Getter
@Setter
public class CreateModel implements Serializable {

	@Inject
	private Logger logger;

	@Inject
	private IBookService bookService;

	@Inject
	@AuthorAnnotation
	private IPersonService<Author> authorService;

	@Inject
	private PersonConverter converter;

	//Book Attributes
	private String name;

	private String isbn;

	private Date release;

	private BigDecimal price;

	private Integer copies;

	private String license;

	private List<Author> authorList;

	private Author[] choosenAuthors;

	private String log;

	//Author Attributes
	private String firstName;

	private String lastName;

	private String street;

	private String city;

	private String postNumber;

	@PostConstruct
	public void init() {
		logger.info("init CreateModel");
		this.copies = null;
		this.authorList = authorService.findAll();
	}

	public Boolean getIsEbook() {
		return (!(this.copies == null));
	}

	public Boolean getIsPaperbook() {
		return !this.license.isEmpty();
	}

	public void createBook() {
		logger.info("createBook CreateAbstractBookModel");
		AbstractBook book;
		if (this.copies != null) {
			book = new PaperBook(this.name, this.isbn, this.release, this.price, this.copies);
		} else {
			book = new ElectronicBook(this.name, this.isbn, this.release, this.price, this.license);
		}
		this.bookService.persistNewBook(book, Arrays.asList(choosenAuthors));

		this.name = "";
		this.isbn = "";
		this.release = null;
		this.price = null;
		this.copies = null;
		this.license = "";
		this.choosenAuthors = null;
	}

	public void createAuthor() {
		logger.info("createAuthor CreateAuthorModel");
		Address address = new Address(this.street, this.city, Integer.valueOf(this.postNumber));
		Author author = new Author(this.firstName, this.lastName, address);
		author = this.authorService.create(author);

		this.authorList.add(author);
		
		this.firstName = "";
		this.lastName = "";
		this.street = "";
		this.city = "";
		this.postNumber = "";
	}
}
