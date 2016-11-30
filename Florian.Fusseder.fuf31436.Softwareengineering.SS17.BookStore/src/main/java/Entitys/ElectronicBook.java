/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Creates a E-AbstractBook
 *
 * @author Florian
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class ElectronicBook extends AbstractBook {

	@NonNull
	private String license;

	public ElectronicBook(String name, String isbn, Date releaseDate, BigDecimal price, String license) {
		super(name, isbn, releaseDate, price);
		this.license = license;
	}

	public ElectronicBook(String name, String isbn, Date releaseDate, BigDecimal price, Author author, String license) {
		super(name, isbn, releaseDate, price);
		this.addAuthor(author);
	}

	public ElectronicBook(String name, String isbn, Date releaseDate, BigDecimal price, List<Author> authorList, String license) {
		super(name, isbn, releaseDate, authorList, price);
		this.license = license;
	}

}
