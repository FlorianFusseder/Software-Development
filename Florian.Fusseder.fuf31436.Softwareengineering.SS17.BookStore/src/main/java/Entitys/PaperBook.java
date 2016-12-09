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

	private int copies;

	public PaperBook(String name, String isbn, Date releaseDate, BigDecimal price, int copies) {
		super(name, isbn, releaseDate, price);
		this.copies = copies;
	}

	public void alterCopies(int copies) {
		this.copies += copies;
	}

	@Override
	public String getSpecificFieldAsString() {
		return (this.copies > 0)?String.valueOf(this.copies) : "Not on Stock";
	}
}
