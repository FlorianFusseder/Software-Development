/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entitys.BankDetail;
import Entitys.Customer;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author Florian
 */
public class BankService
{
    
    @PersistenceContext(unitName = "BookStorePU")
    private EntityManager manager;  
    
    @Transactional(Transactional.TxType.REQUIRED)
    public BankDetail persistCustomer(BankDetail d)
    {
        manager.persist(d);
        return d;
    }
    
}
