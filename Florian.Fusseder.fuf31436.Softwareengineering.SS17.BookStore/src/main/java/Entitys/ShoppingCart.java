/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

import Technicals.Id.GeneratedIdEntity;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Florian
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class ShoppingCart extends GeneratedIdEntity {

	@ManyToMany(fetch = FetchType.EAGER)
	private List<CartItem> shoppingList = new ArrayList<>();

	@Temporal(TemporalType.TIMESTAMP)
	private Date checkoutDate;

	private BigDecimal total = BigDecimal.ZERO;
	
	private Address DeliveryAddress;

	public ShoppingCart(Address DeliveryAddress) {
		this.DeliveryAddress = DeliveryAddress;
	}

	@PreUpdate
	@PrePersist
	private void Load() {
		this.total = this.getTotal();
	}

	public BigDecimal getTotal() {
		return shoppingList.stream()
				.map((cartItem) -> cartItem.getAbstractBook().getPrice().multiply(new BigDecimal(cartItem.getCount())))
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	public List<CartItem> getShoppingList() {
		return Collections.unmodifiableList(shoppingList);
	}

	public void addToShoppingList(CartItem cartItem) {
		this.shoppingList.add(cartItem);
	}

	public void removeFromShoppingList(CartItem cartItem) {
		this.shoppingList.remove(cartItem);
	}

	public void addToShoppingList(List<CartItem> cartItems) {
		this.shoppingList.addAll(cartItems);
	}

	public void clearShoppingCart() {
		this.shoppingList.clear();
	}
}
