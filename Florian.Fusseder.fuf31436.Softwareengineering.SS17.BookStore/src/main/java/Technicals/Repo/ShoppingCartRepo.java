/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Technicals.Repo;

import Entitys.ShoppingCart;

/**
 *
 * @author Florian
 */
public class ShoppingCartRepo extends SingleEntityRepository<Long, ShoppingCart> {

    public ShoppingCartRepo() {
        super(ShoppingCart.class);
    }
}
