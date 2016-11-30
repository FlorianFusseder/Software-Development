/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Technicals.Repo;

import Entitys.BankDetail;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Florian
 */
@RequestScoped
public class BankRepo extends SingleEntityRepository<Long, BankDetail> 
implements Serializable{

    public BankRepo() {
        super(BankDetail.class);
    }

}
