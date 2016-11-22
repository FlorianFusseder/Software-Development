/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entitys.AbstractBook;
import Entitys.ShoppingCart;
import Technicals.Repo.ShoppingCartRepo;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 *
 * @author Florian
 */
public class ShoppingService {

    @Inject
    private ShoppingCartRepo shoppingManager;

    public ShoppingService() {
    }
    

    @Transactional(Transactional.TxType.REQUIRED)
    public void persist(ShoppingCart shoppingCart) {
        this.shoppingManager.persist(shoppingCart);
    }
    
    @Transactional(Transactional.TxType.REQUIRED)
    public void addBookToCart(ShoppingCart shoppingCart, AbstractBook abstractBook) {
        shoppingCart = this.shoppingManager.merge(shoppingCart);
        shoppingCart.addToShoppingList(abstractBook); 
    }
    
    @Transactional(Transactional.TxType.REQUIRED)
    public void addBookListToCart(ShoppingCart shoppingCart, List<AbstractBook> abstractBooks) {
        shoppingCart = this.shoppingManager.merge(shoppingCart);
        shoppingCart.addToShoppingList(abstractBooks);
    }
}
