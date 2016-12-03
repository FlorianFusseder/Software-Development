/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Entitys.AbstractBook;
import Entitys.Customer;
import Services.BookService;
import Services.ShoppingService;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
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
@ConversationScoped
@NoArgsConstructor
public class ShoppingSiteModel implements Serializable {

	@Inject
	private Conversation conversation;

	@Inject
	private BookService bookService;

	@Inject
	private ShoppingService shoppingService;

	//todo: Loginmodel implementen für das shoppingchart
	//@Inject
	//private LogInModel logInModel;

	@Getter
	@Setter
	private Customer customer;

	@Setter
	private List<AbstractBook> bookList;

	public void addBookToCart(String Id) {
		this.shoppingService.addBookToCart(this.customer, Id);
	}

	public void addBookToCart(AbstractBook abstractBook) {
		this.shoppingService.addBookToCart(this.customer, abstractBook);
	}

	public void buyShoppingCart() {
		this.shoppingService.buyCurrentCart(this.customer);

		if (!this.conversation.isTransient()) {
			this.conversation.end();
		}
	}

	public List<AbstractBook> getBookList() {
		if (this.conversation.isTransient()) {
			this.conversation.begin();
		}
		
		//this.customer = this.logInModel.getChoosenCustomer();
		
		
		this.bookList = this.bookService.findAll();
		return bookList;
	}

}
