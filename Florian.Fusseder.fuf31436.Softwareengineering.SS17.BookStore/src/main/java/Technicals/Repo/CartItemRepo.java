/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Technicals.Repo;

import Entitys.CartItem;

/**
 *
 * @author Florian
 */
public class CartItemRepo extends SingleEntityRepository<Long, CartItem>{
	
	public CartItemRepo() {
		super(CartItem.class);
	}
	
}
