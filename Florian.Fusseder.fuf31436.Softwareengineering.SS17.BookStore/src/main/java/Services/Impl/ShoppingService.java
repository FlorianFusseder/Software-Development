/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Impl;

import Entitys.AbstractBook;
import Entitys.Address;
import Entitys.Customer;
import Entitys.ShoppingCart;
import Entitys.CartItem;
import Entitys.PaperBook;
import Services.Interfaces.ICartItemService;
import Services.Interfaces.IShoppingService;
import Technicals.Repo.ShoppingCartRepo;
import java.util.Date;
import java.util.Iterator;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import Config.*;
import Services.Interfaces.ITransactionService;
import Technicals.Repo.AbstractBookRepo;
import Technicals.Repo.CartItemRepo;
import Technicals.Repo.PersonRepo;
import java.math.BigDecimal;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import lombok.NoArgsConstructor;

/**
 *
 *
 * @author Florian
 */
@RequestScoped
@NoArgsConstructor
public class ShoppingService implements IShoppingService {

	@Inject
	private Logger logger;

	@Inject
	private ShoppingCartRepo shoppingCartManager;

	@Inject
	private ICartItemService cartItemManager;

	@Inject
	private CartItemRepo cartItemRepo;

	@Inject
	private PersonRepo personManager;

	@Inject
	private AbstractBookRepo bookManager;

	@Inject
	private ITransactionService paymentManager;

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
		logger.info("Add Book To Cart: Id " + Id);
		this.alterShoppingCart(customer, (AbstractBook) this.bookManager.findById(Id), 1);
	}

	@Transactional(Transactional.TxType.REQUIRED)
	@Override
	public Customer setDeliveryAddress(Customer customer, Address address) {
		logger.info("Set delivery address to cart");
		customer = (Customer) personManager.merge(customer);
		customer.getShoppingCart().setDeliveryAddress(address);
		return customer;
	}

	/**
	 * Wraps a AbstractBook into a CartItem and adds it to the ShoppingCart. If
	 * already existent the counter of the CartItem will be increased by
	 * <amount>.
	 *
	 * @param customer
	 * @param abstractBook
	 * @param amount
	 * @return
	 */
	@Override
	@Transactional
	public Customer alterShoppingCart(Customer customer, AbstractBook abstractBook, int amount) {

		customer = (Customer) this.personManager.merge(customer);
		abstractBook = this.bookManager.merge(abstractBook);
		ShoppingCart shoppingCart = customer.getShoppingCart();
		Iterator<CartItem> items = shoppingCart.getShoppingList().iterator();

		while (items.hasNext()) {
			CartItem cartItem = items.next();

			if (cartItem.getAbstractBook().equals(abstractBook)) {
				CartItem ci = cartItem;
				ci.alterCount(amount);
				if (ci.getCount() < 1) {
					this.cartItemManager.remove(customer, ci);
				}
				return customer;
			}
		}

		if (amount > 0) {
			CartItem cartItem = new CartItem(abstractBook, amount);
			this.cartItemRepo.persist(cartItem);
			shoppingCart.addToShoppingList(cartItem);
		}
		return customer;

	}

	@Transactional(Transactional.TxType.REQUIRED)
	@Override
	public Customer buyCurrentCart(Customer customer) {
		
		logger.info("Buy current cart");

		customer = (Customer) personManager.merge(customer);
		ShoppingCart shoppingCart = customer.getShoppingCart();

		Boolean success = this.paymentManager.transfer(shoppingCart.getTotal().multiply(BigDecimal.valueOf(100)).longValue(),
				customer.getBankDetail().getIban(), Config.getMyIban(),
				"Payment to \"The One BookStore\"");

		if (!success) {
			return customer;
		}

		for (CartItem cartItem : shoppingCart.getShoppingList()) {

			AbstractBook abstractbook = cartItem.getAbstractBook();
			int copiesSold = cartItem.getCount();

			if (abstractbook.getClass() == PaperBook.class) {
				PaperBook pb = (PaperBook) abstractbook;
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
