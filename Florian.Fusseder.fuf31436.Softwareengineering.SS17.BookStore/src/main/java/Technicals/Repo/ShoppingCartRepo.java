/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Technicals.Repo;

import Entitys.ShoppingCart;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Florian
 */
@SessionScoped
public class ShoppingCartRepo extends SingleEntityRepository<Long, ShoppingCart>
implements Serializable {

    public ShoppingCartRepo() {
        super(ShoppingCart.class);
    }
}
