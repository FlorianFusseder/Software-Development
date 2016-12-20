/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Interfaces;

import Entitys.AbstractBook;
import Entitys.Customer;
import Entitys.ShoppingCart;
import java.io.Serializable;

/**
 *
 * @author Florian
 */
public interface IShoppingService extends Serializable {

	public void persist(ShoppingCart shoppingCart);

	public void addBookToCart(Customer customer, String Id);

	public Customer alterShoppingCart(Customer customer, AbstractBook abstractBook, int amount);

	public Customer buyCurrentCart(Customer customer);

}
