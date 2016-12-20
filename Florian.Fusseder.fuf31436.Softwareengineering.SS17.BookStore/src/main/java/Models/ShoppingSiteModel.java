/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Annotations.PersonAnnotation;
import Entitys.AbstractBook;
import Entitys.Author;
import Entitys.CartItem;
import Entitys.Customer;
import Entitys.ShoppingCart;
import Services.Impl.BookService;
import Services.Impl.ShoppingService;
import Services.Interfaces.IPersonService;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.convert.ConverterIMPL;
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
@SessionScoped
@NoArgsConstructor
@ManagedBean
public class ShoppingSiteModel implements Serializable {

	@Inject
	private BookService bookService;

	@Inject
	private ShoppingService shoppingService;

	@Inject
	@PersonAnnotation
	private IPersonService personService;

	@Getter
	@Setter
	private Customer customer;

	@Setter
	private List<AbstractBook> bookList;

	@Inject
	@Getter
	@Setter
	private ConverterIMPL converter;

	@Getter
	@Setter
	private String searchTerm;

	@PostConstruct
	public void init() {
		searchTerm = "";
		this.bookList = this.bookService.findAll();
	}

	public List<AbstractBook> getBookList() {
		if (searchTerm.isEmpty()) {
			this.bookList = this.bookService.findAll();
		}
		return bookList;
	}

	public void searchFor() {
		this.bookList = this.bookService.searchBooks(this.searchTerm);
	}

	public List<ShoppingCart> getAllBoughtCarts() {
		return this.customer.getPayedShoppingCarts().stream()
				.sorted((ShoppingCart t, ShoppingCart t1) -> {
					if (t.getCheckoutDate().after(t1.getCheckoutDate())) {
						return -1;
					} else {
						return 1;
					}
				})
				.collect(Collectors.toList());

	}

	public ShoppingCart getShoppingCart() {
		return this.customer.getShoppingCart();
	}

	public String buyShoppingCart() {
		if (!this.customer.getShoppingCart().getShoppingList().isEmpty()) {
			this.customer = this.shoppingService.buyCurrentCart(this.customer);
			this.searchTerm = "";
			this.init();
			return "order";
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

	public String authorsAsString(List<Author> authorList) {
		return authorList.stream().map(a -> (a.getFirstName() + " " + a.getLastName())).collect(Collectors.joining(", "));
	}
	
	public String logout(){
		this.searchTerm = "";
		this.customer = null;
		return "login";
	}
}
