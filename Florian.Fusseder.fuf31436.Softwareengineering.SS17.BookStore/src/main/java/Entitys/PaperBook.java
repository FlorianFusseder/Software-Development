/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Creates a Paperbook object
 *
 * @author Florian
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class PaperBook extends AbstractBook {

	private long copies;

	public PaperBook(String name, String isbn, Date releaseDate, BigDecimal price, long copies) {
		super(name, isbn, releaseDate, price);
		this.copies = copies;
	}

	public void addCopies(Long copies) {
		this.copies += copies;
	}
}
