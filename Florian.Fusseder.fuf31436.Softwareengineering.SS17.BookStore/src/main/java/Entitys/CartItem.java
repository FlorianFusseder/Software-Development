/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

import Technicals.Id.GeneratedIdEntity;
import javax.persistence.Entity;

/**
 *
 * @author Florian
 */
@Entity
public class CartItem extends GeneratedIdEntity {

	
	private AbstractBook abstractBook;
	private int count;

	public CartItem() {
	}

	public CartItem(AbstractBook abstractBook, int count) {
		this.abstractBook = abstractBook;
		this.count = count;
	}

	public AbstractBook getAbstractBook() {
		return abstractBook;
	}

	public void setAbstractBook(AbstractBook abstractBook) {
		this.abstractBook = abstractBook;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public void addCount(int i){
		this.count += i;
	}

	@Override
	public String toString() {
		return "ShoppingCartItem{" + "abstractBook=" + abstractBook + ", count=" + count + '}';
	}
}
