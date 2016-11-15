/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entitys.BankDetail;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author Florian
 */
@Transactional(Transactional.TxType.REQUIRED)
public class BankService
{
    
    @PersistenceContext(unitName = "BookStorePU")
    private EntityManager manager;  
    
    
    public BankDetail persistCustomer(BankDetail d)
    {
        manager.persist(d);
        return d;
    }
    
}
