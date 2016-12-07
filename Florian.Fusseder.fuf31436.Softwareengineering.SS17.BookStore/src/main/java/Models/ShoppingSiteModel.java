/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Entitys.AbstractBook;
import Entitys.CartItem;
import Entitys.Customer;
import Entitys.ShoppingCart;
import Services.BookService;
import Services.PersonService;
import Services.ShoppingService;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.convert.CustomerConverter;
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
@ApplicationScoped
@NoArgsConstructor
@ManagedBean
public class ShoppingSiteModel implements Serializable {

	@Inject
	private BookService bookService;

	@Inject
	private ShoppingService shoppingService;

	@Inject
	private PersonService personService;

	@Getter
	@Setter
	private Customer customer;

	@Setter
	private List<AbstractBook> bookList;

	//todo: warum unsatisfiyd dependency?
	@Inject
	@Getter
	@Setter
	private CustomerConverter converter;

	public List<AbstractBook> getBookList() {
		this.bookList = this.bookService.findAll();
		return this.bookList;
	}

	public ShoppingCart getShoppingCart() {
		return this.customer.getShoppingCart();
	}

	public void addBookToCart(String Id) {
		this.shoppingService.addBookToCart(this.customer, Id);
	}

	public String  buyShoppingCart() {
		this.customer = this.shoppingService.buyCurrentCart(this.customer);
		return "/ShoppingSite.xhtml";
	}

	public List<Customer> getCustomerList() {
		List<Customer> customerList = personService.findAll()
				.stream()
				.filter(p -> p.getClass() == Customer.class)
				.map(p -> (Customer) p)
				.collect(Collectors.toList());

		return customerList;
	}
	
	public void removeBook(CartItem cartItem){
		this.customer = shoppingService.alterShoppingCart(this.customer, cartItem.getAbstractBook(), -1);
	}

}
