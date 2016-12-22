/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Impl;

import Entitys.AbstractBook;
import Entitys.Customer;
import Entitys.ShoppingCart;
import Entitys.CartItem;
import Entitys.PaperBook;
import Services.Interfaces.IBookService;
import Services.Interfaces.ICartItemService;
import Services.Interfaces.IShoppingService;
import Technicals.Repo.PersonRepo;
import Technicals.Repo.ShoppingCartRepo;
import java.util.Date;
import java.util.Iterator;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 *
 * @author Florian
 */
@RequestScoped
public class ShoppingService implements IShoppingService {

	@Inject
	private ShoppingCartRepo shoppingCartManager;

	@Inject
	private ICartItemService cartItemManager;

	@Inject
	private PersonRepo personManager;

	@Inject
	private IBookService bookManager;

	public ShoppingService() {
	}

	@Transactional(Transactional.TxType.REQUIRED)
	@Override
	public void persist(ShoppingCart shoppingCart) {
		this.shoppingCartManager.persist(shoppingCart);
	}

	/**
	 * Wraps AbstractBook from the Id into a CartItem and adds it to the
	 * ShoppingCart. If already existent the counter of the CartItem will be
	 * increased by 1.
	 *
	 * @param customer
	 * @param Id
	 */
	@Transactional(Transactional.TxType.REQUIRED)
	@Override
	public void addBookToCart(Customer customer, String Id) {
		this.alterShoppingCart(customer,(AbstractBook) this.bookManager.find(Id), 1);
	}

	/**
	 * Wraps a AbstractBook into a CartItem and adds it to the ShoppingCart. If
	 * already existent the counter of the CartItem will be increased by
	 * <amount>.
	 *
	 * @param customer
	 * @param abstractBook
	 * @param amount
	 */
	@Transactional(Transactional.TxType.REQUIRED)
	@Override
	public Customer alterShoppingCart(Customer customer, AbstractBook abstractBook, int amount) {

		customer = (Customer) this.personManager.merge(customer);
		ShoppingCart shoppingCart = this.shoppingCartManager.merge(customer.getShoppingCart());
		Iterator<CartItem> items = shoppingCart.getShoppingList().iterator();

		while (items.hasNext()) {
			CartItem cartItem = items.next();

			if (cartItem.getAbstractBook().equals(abstractBook)) {
				CartItem ci = cartItemManager.merge(cartItem);
				ci.alterCount(amount);
				if (ci.getCount() < 1) {
					this.cartItemManager.remove(customer, ci);
				}
				return customer;
			}
		}

		if (amount > 0) {
			CartItem cartItem = new CartItem(abstractBook, amount);
			cartItemManager.persist(cartItem);
			shoppingCart.addToShoppingList(cartItem);
		}
		return customer;
	}

	@Transactional(Transactional.TxType.REQUIRED)
	@Override
	public Customer buyCurrentCart(Customer customer) {
		
		//todo current cart muss noch aktualisert werden wegen lieferadresse! anosten geht sie hier beim merge verloren!
		customer = (Customer) personManager.merge(customer);
		ShoppingCart shoppingCart = shoppingCartManager.merge(customer.getShoppingCart());

		for (CartItem cartItem : shoppingCart.getShoppingList()) {

			AbstractBook abstractbook = cartItem.getAbstractBook();
			int copiesSold = cartItem.getCount();

			if (abstractbook.getClass() == PaperBook.class) {
				PaperBook pb = (PaperBook) bookManager.merge(abstractbook);
				pb.alterCopies(-copiesSold);
			}
		}

		shoppingCart.setCheckoutDate(new Date());
		customer.addPayedShoppingCart(shoppingCart);
		ShoppingCart newCart = new ShoppingCart();
		shoppingCartManager.persist(newCart);
		customer.setShoppingCart(newCart);
		return customer;
	}
}
