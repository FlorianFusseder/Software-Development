/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entitys.CartItem;
import Entitys.Customer;
import Entitys.ShoppingCart;
import Technicals.Repo.CartItemRepo;
import Technicals.Repo.PersonRepo;
import Technicals.Repo.ShoppingCartRepo;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 *
 * @author Florian
 */
@RequestScoped
public class CartItemService {

	@Inject
	private PersonRepo personManager;

	@Inject
	private CartItemRepo cartItemManager;

	@Inject
	private ShoppingCartRepo shoppingCartService;

	@Transactional(Transactional.TxType.REQUIRED)
	public void remove(Customer customer, CartItem cartItem) {
		customer = (Customer) personManager.merge(customer);
		ShoppingCart shoppingCart = this.shoppingCartService.merge(customer.getShoppingCart());

		shoppingCart.removeFromShoppingList(cartItem);
		this.cartItemManager.remove(cartItem);
	}

	@Transactional(Transactional.TxType.REQUIRED)
	public void persist(CartItem cartItem) {
		this.cartItemManager.persist(cartItem);
	}

	@Transactional(Transactional.TxType.REQUIRED)
	public CartItem merge(CartItem cartItem) {
		return this.cartItemManager.merge(cartItem);
	}

}
