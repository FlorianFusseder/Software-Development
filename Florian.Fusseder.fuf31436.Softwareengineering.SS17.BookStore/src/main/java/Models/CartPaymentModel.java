/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Entitys.CartItem;
import Entitys.Customer;
import Entitys.ShoppingCart;
import Services.PersonService;
import Services.ShoppingService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Florian
 */
@Named
@RequestScoped
@Getter
@Setter
@NoArgsConstructor
@ManagedBean
public class CartPaymentModel implements Serializable {

	@Inject
	private ShoppingService shoppingService;

	@Inject
	private ShoppingSiteModel shoppingSiteModel;
	
	@Inject
	private PersonService personService;

	private Customer customer;

	private List<CartItem> shoppingCart;

	@PostConstruct
	public void init() {
		
		//todo: sobald converter implementiert hier auf Conversationsonscopded umstellen, zeilen 53 54 wieder inkommentieren
		// zeilen <57 58> löschen und auch den Personenservice wieder löschen 42 43
		//this.customer = this.shoppingSiteModel.getCustomer();
		//this.shoppingCart = this.customer.getShoppingCart();
		
		this.customer = (Customer) personService.findAll().get(3);
		this.shoppingCart = this.customer.getShoppingCart().getShoppingList();
	}
	
	public void buyNow(){
		this.shoppingService.buyCurrentCart(this.customer);
	}

}
