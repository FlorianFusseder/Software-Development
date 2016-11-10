/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * 
 * @author Florian
 */
@Entity
public class Customer extends Person
{
    @OneToOne
    private BankDetail bankDetail;
    
    @ElementCollection
    @OneToMany
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
        return bills;
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
