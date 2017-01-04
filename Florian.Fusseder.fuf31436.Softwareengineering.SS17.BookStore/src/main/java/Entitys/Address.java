/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents an Address
 *
 * @author Florian
 */
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Address implements Serializable {

	private String street;

	private String city;

	private Integer postNumber;

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}

		Address a = (Address) obj;
		return !(!this.city.equals(a.city)
				|| !this.street.equals(a.street)
				|| (!Objects.equals(this.postNumber, a.postNumber)));
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.city, this.street, this.postNumber);
	}

}
