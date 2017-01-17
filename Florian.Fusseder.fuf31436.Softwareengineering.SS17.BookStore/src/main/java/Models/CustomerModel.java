/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Annotations.CustomerAnnotation;
import Entitys.AbstractBook;
import Entitys.Author;
import Entitys.CartItem;
import Entitys.Customer;
import Entitys.ShoppingCart;
import Services.Interfaces.IBookService;
import Services.Interfaces.IPersonService;
import Services.Interfaces.IShoppingService;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.convert.PersonConverter;
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
public class CustomerModel implements Serializable {

	@Inject
	private Logger logger;

	@Inject
	private IShoppingService shoppingService;

	@Inject
	@CustomerAnnotation
	private IPersonService<Customer> customerService;

	@Getter
	@Setter
	private Customer customer;

	@Inject
	@Getter
	@Setter
	private PersonConverter converter;

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

	public String acceptShoppingCart() {
		logger.info("accpetShoppingCart ShoppingSiteModel");
		if (!this.customer.getShoppingCart().getShoppingList().isEmpty()) {
			return "chooseDelivery";
		}
		return "";
	}

	public String buyShoppingCart() {
		logger.info("buyShoppingCart ShoppingSiteModel");
		if (!this.customer.getShoppingCart().getShoppingList().isEmpty()) {
			this.customer = this.shoppingService.buyCurrentCart(this.customer);
			return "shop";
		}
		return "";
	}

	public List<Customer> getCustomerList() {
		logger.info("getCustomerList ShoppingSiteModel");
		List<Customer> customerList = this.customerService.findAll();
		return customerList;
	}

	public void addBookToCart(AbstractBook book) {
		logger.info("addBookToCart ShoppingSiteModel");
		this.customer = this.shoppingService.alterShoppingCart(this.customer, book, 1);
	}

	public void removeBook(CartItem cartItem) {
		logger.info("removeBook ShoppingSiteModel");
		this.customer = shoppingService.alterShoppingCart(this.customer, cartItem.getAbstractBook(), -1);
	}

	public int booksInCart() {
		logger.info("BooksInCart ShoppingSiteModel");
		return this.customer.getShoppingCart().getShoppingList().stream()
				.mapToInt(ci -> ci.getCount())
				.sum();
	}

	public String authorsAsString(List<Author> authorList) {
		return authorList.stream().map(a -> (a.getFirstName() + " " + a.getLastName())).collect(Collectors.joining(", "));
	}

	public String logout() {
		logger.info("Logout ShoppingSiteModel");
		this.customer = null;
		return "login";
	}
}
