/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Impl;

import Entitys.CartItem;
import Entitys.Customer;
import Services.Interfaces.ICartItemService;
import Technicals.Repo.CartItemRepo;
import Technicals.Repo.PersonRepo;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import lombok.NoArgsConstructor;

/**
 *
 * @author Florian
 */
@RequestScoped
@NoArgsConstructor
public class CartItemService implements ICartItemService{

	@Inject
	private PersonRepo personManager;

	@Inject
	private CartItemRepo cartItemManager;

	@Transactional(Transactional.TxType.REQUIRED)
	@Override
	public void remove(Customer customer, CartItem cartItem) {
		customer = (Customer) personManager.merge(customer);

		customer.getShoppingCart().removeFromShoppingList(cartItem);
		this.cartItemManager.remove(cartItem);
	}
	
}
