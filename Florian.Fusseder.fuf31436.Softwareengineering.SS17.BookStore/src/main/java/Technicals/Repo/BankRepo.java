/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Technicals.Repo;

import Entitys.BankDetail;

/**
 *
 * @author Florian
 */
public class BankRepo extends SingleEntityRepository<Long, BankDetail> {

    public BankRepo() {
        super(BankDetail.class);
    }

}
