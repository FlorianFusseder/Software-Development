/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entitys.AbstractBook;
import Entitys.Customer;
import Entitys.ShoppingCart;
import Entitys.CartItem;
import Technicals.Repo.CartItemRepo;
import Technicals.Repo.PersonRepo;
import Technicals.Repo.ShoppingCartRepo;
import java.io.Serializable;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 *
 * @author Florian
 */
//todo: Macht converstaionscoped sinn in Services?

@ConversationScoped
public class ShoppingService implements Serializable{

	@Inject
	private Conversation conversation;
	
	@Inject
	private ShoppingCartRepo shoppingManager;

	@Inject
	private CartItemRepo cartItemManager;

	@Inject
	private PersonRepo personManager;
	
	@Inject
	private BookService bookService;

	public ShoppingService() {
	}

	@Transactional(Transactional.TxType.REQUIRED)
	public void persist(ShoppingCart shoppingCart) {
		this.shoppingManager.persist(shoppingCart);
	}
	
	public void addBookToCart(Customer customer, String Id){
		if(this.conversation.isTransient())
			this.conversation.begin();
		
		addBookToCart(customer, bookService.findById(Id));
	}

	/**
	 * Wraps a AbstractBook into a CartItem and adds it to the ShoppingCart.
	 * If already existent the counter of the CartItem will be increased by one.
	 * @param customer
	 * @param abstractBook 
	 */
	@Transactional(Transactional.TxType.REQUIRED)
	public void addBookToCart(Customer customer, AbstractBook abstractBook) {
		
		if(this.conversation.isTransient())
			this.conversation.begin();
		
		addBookToCart(customer, abstractBook, 1);
	}

	/**
	 * Wraps a AbstractBook into a CartItem and adds it to the ShoppingCart.
	 * If already existent the counter of the CartItem will be increased 
	 * by <amount>.
	 * @param customer
	 * @param abstractBook
	 * @param amount 
	 */
	@Transactional(Transactional.TxType.REQUIRED)
	public void addBookToCart(Customer customer, AbstractBook abstractBook, int amount) {
		
		if(this.conversation.isTransient())
			this.conversation.begin();
		
		
		customer = (Customer) this.personManager.merge(customer);
		ShoppingCart shoppingCart = this.shoppingManager.merge(customer.getShoppingCart());

		for (CartItem cartItem : shoppingCart.getShoppingList()) {
			if (cartItem.getAbstractBook() == abstractBook) {
				CartItem ci = cartItemManager.merge(cartItem);
				ci.addCount(1);
				return;
			}
		}

		CartItem cartItem = new CartItem(abstractBook, amount);
		cartItemManager.persist(cartItem);
		shoppingCart.addToShoppingList(cartItem);
	}
	
	@Transactional(Transactional.TxType.REQUIRED)
	public void buyCurrentCart(Customer customer){
		customer = (Customer) personManager.merge(customer);
		ShoppingCart shoppingCart = shoppingManager.merge(customer.getShoppingCart());
		
		customer.addPayedShoppingCart(shoppingCart);
		ShoppingCart newCart = new ShoppingCart();
		shoppingManager.persist(newCart);
		customer.setShoppingCart(newCart);
	}
}
