/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entitys.BankDetail;
import Technicals.Repo.BankRepo;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 *
 * @author Florian
 */
public class BankService {

    @Inject
    private BankRepo bankManager;

    public BankService() {
    }
    
    @Transactional(Transactional.TxType.REQUIRED)
    public void persist(BankDetail b) {
        this.bankManager.persist(b);
    }
}
