/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entitys.Bill;
import Entitys.Customer;
import Technicals.Repo.BillRepo;
import Technicals.Repo.PersonRepo;
import Technicals.Repo.ShoppingCartRepo;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 *
 * @author Florian
 */
public class BillService {

    @Inject
    private BillRepo billManager;
    
    @Inject
    private PersonRepo personManager;
    
    @Inject
    private ShoppingCartRepo shoppingCartManager;

    public BillService() {
    }

    public void persist(Bill b) {
        billManager.persist(b);
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public Bill createBill(Customer customer) {
        customer = (Customer) this.personManager.merge(customer);
        Bill bill = new Bill(customer);
        billManager.persist(bill);
        //todo: uncomment for clearing cart when creating a bill
        //ShoppingCart shoppingCart = this.shoppingCartManager.merge(customer.getShoppingCart());
        //shoppingCart.clearShoppingCart();
        return bill;
    }

}
