/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

import Technicals.Id.GeneratedIdEntity;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Florian
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class CartItem extends GeneratedIdEntity {

	private AbstractBook abstractBook;

	private int count;

	/**
	 * Alters the amount of Books in this item and returns the new amount
	 * @param i
	 * @return 
	 */
	public int alterCount(int i) {
		return this.count += i;
	}
}
