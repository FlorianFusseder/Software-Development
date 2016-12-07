/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Entitys.AbstractBook;
import Entitys.Author;
import Entitys.ElectronicBook;
import Entitys.PaperBook;
import Services.BookService;
import Services.PersonService;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.AuthorConverter;
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
@ManagedBean
@Getter
@Setter
public class CreateAbstractBookModel implements Serializable {

	@Inject
	private BookService bookService;

	@Inject
	private PersonService personService;

	@Inject
	private AuthorConverter converter;

	private String name;

	private String isbn;

	private Date release;

	private BigDecimal price;

	private Integer copies;

	private String license;

	private List<Author> authorList;

	private Author[] choosenAuthors;

	private String log;

	@PostConstruct
	public void init() {
		this.log = "";
		this.copies = null;
		this.authorList = personService.findAll()
				.stream()
				.filter(p -> p.getClass() == Author.class)
				.map(p -> (Author) p)
				.collect(Collectors.toList());
	}

	public List<Author> getAuthorList() {
		this.authorList = personService.findAll()
				.stream()
				.filter(p -> p.getClass() == Author.class)
				.map(p -> (Author) p)
				.collect(Collectors.toList());
		
		return this.authorList;
	}

	public void createBook() {
		AbstractBook book;
		if (this.copies != null) {
			book = new PaperBook(this.name, this.isbn, this.release, this.price, this.copies);
		} else {
			book = new ElectronicBook(this.name, this.isbn, this.release, this.price, this.license);
		}
		this.bookService.persistNewBook(book, Arrays.asList(choosenAuthors));

		this.log += "New Book " + this.name + " " + this.price + " created\n";

		this.name = "";
		this.isbn = "";
		this.release = null;
		this.price = null;
		this.copies = null;
		this.license = "";
		this.choosenAuthors = null;
	}

}
