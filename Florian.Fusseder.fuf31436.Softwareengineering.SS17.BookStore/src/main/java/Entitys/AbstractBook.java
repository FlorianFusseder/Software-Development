/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

import Technicals.Id.RandomIdEntity;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Abstract AbstractBook Class
 *
 * @author Florian
 */
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
abstract public class AbstractBook extends RandomIdEntity {

	@NonNull
	@Column(name = "title")
	private String name;

	@NonNull
	private String isbn;

	@NonNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date release;
	
	@ManyToMany(mappedBy = "books", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Author> author = new ArrayList<>();

	@NonNull
	private BigDecimal price;
	
	public List<Author> getAuthor() {
		return Collections.unmodifiableList(this.author);
	}

	public void addAuthor(Author author) {
		this.author.add(author);
	}
	
	public abstract String getSpecificFieldAsString();
}
