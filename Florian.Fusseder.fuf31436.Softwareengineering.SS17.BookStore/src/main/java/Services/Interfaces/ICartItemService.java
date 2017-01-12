/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Interfaces;

import Entitys.CartItem;
import Entitys.Customer;
import java.io.Serializable;

/**
 *
 * @author Florian
 */
public interface ICartItemService extends Serializable{
	
	public void remove(Customer customer, CartItem cartItem);
	
}
