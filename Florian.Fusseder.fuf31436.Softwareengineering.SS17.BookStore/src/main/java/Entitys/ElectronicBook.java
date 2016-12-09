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
import lombok.NonNull;
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

	@Override
	public String getSpecificFieldAsString() {
		return this.license;
	}
}
