/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @author Florian
 */
@Entity
@Table(name = "customer")
public class Customer extends Person
{
    @OneToOne
    private BankDetail bankDetail;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<Bill> bills;

    public Customer()
    {
        bills = new ArrayList<>();
    }

    public Customer(BankDetail bankDetail, String name, Adress adress)
    {
        super(name, adress);
        this.bills = new ArrayList<>();
        this.bankDetail = bankDetail;
    }
    
    public Customer(String name, Adress adress, BankDetail bankDetail, List<Bill> bills)
    {
        super(name, adress);
        this.bankDetail = bankDetail;
        this.bills = bills;
    }

    public BankDetail getBankDetail()
    {
        return bankDetail;
    }

    public void setBankDetail(BankDetail bankDetail)
    {
        this.bankDetail = bankDetail;
    }

    public List<Bill> getBills()
    {
        return Collections.unmodifiableList(bills);
    }

    public void setBills(List<Bill> bills)
    {
        this.bills = bills;
    }

    @Override
    public String toString()
    {
        return super.toString() + " Customer{" + "bankDetail=" + bankDetail + ", bills=" + bills + '}';
    }

    
}
