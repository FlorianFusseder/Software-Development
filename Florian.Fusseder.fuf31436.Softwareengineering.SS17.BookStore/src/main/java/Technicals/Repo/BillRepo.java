/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Technicals.Repo;

import Entitys.AbstractBook;
import Entitys.Bill;
import Entitys.Person;

/**
 *
 * @author Florian
 */
public class BillRepo extends SingleEntityRepository<Long, Bill> {

    public BillRepo() {
        super(Bill.class);
    }
}