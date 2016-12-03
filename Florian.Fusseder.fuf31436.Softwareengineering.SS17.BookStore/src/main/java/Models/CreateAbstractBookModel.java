/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Entitys.Adress;
import Entitys.Author;
import Entitys.BankDetail;
import Entitys.PaperBook;
import Services.BookService;
import Services.PersonService;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
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

	private String name;

	private String isbn;

	private Date release;

	private List<Author> author = new ArrayList<>();

	private BigDecimal price;

	private Integer copies;

	private String license;
	
	@PostConstruct
	public void init(){
		this.copies = null;
	}

	public void createBook() {
		if(this.copies != null)
			this.bookService.persistNewBook(new PaperBook(this.name, this.isbn, this.release, this.author, this.price, this.copies), author);
	}

}
