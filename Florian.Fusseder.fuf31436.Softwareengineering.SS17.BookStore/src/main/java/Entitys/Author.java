/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents an Author
 *
 * @author Florian
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true, exclude = "books")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Author extends Person {
	
	@XmlTransient
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY) //todo eager weischt?
	private List<AbstractBook> books = new ArrayList<>();

	public Author(String firstName, String lastName, List<Address> address) {
		super(firstName, lastName, address);
	}
	
	public Author(String firstName, String lastName, List<Address> address, AbstractBook book) {
		super(firstName, lastName, address);
		this.books.add(book);
	}

	public Author(String firstName, String lastName, List<Address> address, List<AbstractBook> books) {
		super(firstName, lastName, address);
		books.addAll(books);
	}

	public List<AbstractBook> getBooks() {
		return Collections.unmodifiableList(this.books);
	}
	
	public void addBook(AbstractBook book){
		this.books.add(book);
	}
}
