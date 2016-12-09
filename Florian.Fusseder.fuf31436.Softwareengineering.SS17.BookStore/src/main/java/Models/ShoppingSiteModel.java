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
import javax.annotation.PostConstruct;
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
	@Getter
	private List<AbstractBook> bookList;

	@Inject
	@Getter
	@Setter
	private CustomerConverter converter;
	
	@Getter
	@Setter
	private String searchTerm;
	
	@PostConstruct
	public void init(){
		this.bookList = this.bookService.findAll();
	}

	public List<AbstractBook> getBookList() {
		return this.bookList;
	}
	
	public List<ShoppingCart> getAllBoughtCarts(){
		return this.customer.getPayedShoppingCarts();
	}

	public ShoppingCart getShoppingCart() {
		return this.customer.getShoppingCart();
	}

	public String buyShoppingCart() {
		if (!this.customer.getShoppingCart().getShoppingList().isEmpty()) {
			this.customer = this.shoppingService.buyCurrentCart(this.customer);
			this.searchTerm = "";
			this.init();
			return "/ShoppingSite.xhtml";
		}
		return "";
	}

	public List<Customer> getCustomerList() {
		List<Customer> customerList = personService.findAll()
				.stream()
				.filter(p -> p.getClass() == Customer.class)
				.map(p -> (Customer) p)
				.collect(Collectors.toList());

		return customerList;
	}

	public void addBookToCart(AbstractBook book) {
		this.customer = this.shoppingService.alterShoppingCart(this.customer, book, 1);
	}

	public void removeBook(CartItem cartItem) {
		this.customer = shoppingService.alterShoppingCart(this.customer, cartItem.getAbstractBook(), -1);
	}

	public int booksInCart() {
		return this.customer.getShoppingCart().getShoppingList().stream()
				.mapToInt(ci -> ci.getCount())
				.sum();
	}
	
	public void searchFor(){
		this.bookList = this.bookService.searchBooks(this.searchTerm);
	}

}
