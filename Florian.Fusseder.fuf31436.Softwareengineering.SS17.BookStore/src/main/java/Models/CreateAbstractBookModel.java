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
import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
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
	PersonService personService;

	private String name;

	private String isbn;

	private Date release;

	private BigDecimal price;

	private Integer copies;

	private String license;

	//todo: Converter needed
	private Map<String, Author> authorMap;

	private Author choosenAuthors;

	@PostConstruct
	public void init() {

		this.copies = null;
		this.authorMap = personService.findAll()
				.stream()
				.filter(p -> p.getClass() == Author.class)
				.map(p -> (Author) p)
				.collect(Collectors.toMap(a -> a.getFirstName() + " " + a.getLastName(), a -> a));
	}

	public void createBook() {
		AbstractBook book;
		if (this.copies != null) {
			book = new PaperBook(this.name, this.isbn, this.release, this.price, this.copies);
		} else {
			book = new ElectronicBook(this.name, this.isbn, this.release, this.price, this.license);
		}

		this.bookService.persistNewBook(book, this.choosenAuthors);

	}

}
