/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entitys.AbstractBook;
import Entitys.Customer;
import Entitys.ShoppingCart;
import Technicals.Repo.AbstractBookRepo;
import Technicals.Repo.PersonRepo;
import Technicals.Repo.ShoppingCartRepo;
import java.util.ArrayList;
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
    
    @Inject
    private AbstractBookRepo bookManager;
    
    @Inject
    private PersonRepo personManager;

    public ShoppingService() {
    }
    

    @Transactional(Transactional.TxType.REQUIRED)
    public void persist(ShoppingCart shoppingCart) {
        this.shoppingManager.persist(shoppingCart);
    }
    
    @Transactional(Transactional.TxType.REQUIRED)
    public void addBookToCart(Customer customer, AbstractBook abstractBook) {
        customer = (Customer) this.personManager.merge(customer);
        ShoppingCart shoppingCart = this.shoppingManager.merge(customer.getShoppingCart());
        abstractBook = this.bookManager.merge(abstractBook);
        shoppingCart.addToShoppingList(abstractBook); 
    }
    
    @Transactional(Transactional.TxType.REQUIRED)
    public void addBookListToCart(Customer customer, List<AbstractBook> abstractBooks) {
        customer = (Customer) this.personManager.merge(customer);
        ShoppingCart shoppingCart = this.shoppingManager.merge(customer.getShoppingCart());
        List<AbstractBook> books = new ArrayList<>();
        
        abstractBooks.forEach(b -> books.add(this.bookManager.merge(b)));
        shoppingCart.addToShoppingList(books); 
    }

}
