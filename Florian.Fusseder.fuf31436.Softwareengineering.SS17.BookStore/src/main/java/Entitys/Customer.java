/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Creates a Customer
 *
 * @author Florian
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class Customer extends Person {

	@OneToOne
	private BankDetail bankDetail;

	@OneToOne
	private ShoppingCart shoppingCart = new ShoppingCart();

	@OneToMany
	private List<ShoppingCart> payedShoppingCarts = new ArrayList();

	public Customer(String firstName, String lastName, List<Address> adress) {
		super(firstName, lastName, adress);
	}

	public Customer(String firstName, String lastName, List<Address> address, ShoppingCart shoppingCart) {
		super(firstName, lastName, address);
		this.shoppingCart = shoppingCart;
	}

	public List<ShoppingCart> getShoppingCarts() {
		return Collections.unmodifiableList(this.payedShoppingCarts);
	}

	public void addPayedShoppingCart(ShoppingCart shoppingCart) {
		this.payedShoppingCarts.add(0, shoppingCart);
	}

	public BigDecimal getTotalPayment() {
		return this.payedShoppingCarts.stream()
				.map(e -> e.getTotal())
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}
}
