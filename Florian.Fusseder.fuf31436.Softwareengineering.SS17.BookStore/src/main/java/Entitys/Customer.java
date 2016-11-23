/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Creates a Customer
 *
 * @author Florian
 */
@Entity
@Table(name = "customer")
public class Customer extends Person {

    @OneToOne
    private BankDetail bankDetail;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Bill> bills;

    @OneToOne
    private ShoppingCart shoppingCart;

    /**
     * Creates a customer with empty fields and initializes a empty List of Bill
     * and a ShoppingCart
     */
    public Customer() {
        this.bills = new ArrayList<>();
    }

    /**
     * Creates a customer with given fieldes
     *
     * @param firstName
     * @param lastName
     * @param adress
     */
    public Customer(String firstName, String lastName, Adress adress) {
        super(firstName, lastName, adress);
    }

    /**
     * Creates a customer with given fieldes
     *
     * @param firstName
     * @param lastName
     * @param adress
     * @param bankDetail
     */
    public Customer(String firstName, String lastName, Adress adress, BankDetail bankDetail) {
        super(firstName, lastName, adress);
        this.bankDetail = bankDetail;
        this.bills = new ArrayList<>();
    }

    /**
     * Creates a customer with given fieldes
     *
     * @param firstName
     * @param lastName
     * @param adress
     * @param bankDetail
     * @param bills
     */
    public Customer(String firstName, String lastName, Adress adress, BankDetail bankDetail, List<Bill> bills) {
        super(firstName, lastName, adress);
        this.bankDetail = bankDetail;
        this.bills = bills;
    }

    public BankDetail getBankDetail() {
        return bankDetail;
    }

    public void setBankDetail(BankDetail bankDetail) {
        this.bankDetail = bankDetail;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public List<Bill> getBills() {
        return Collections.unmodifiableList(bills);
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

    public BigDecimal getTotalPayment() {
        BigDecimal dec = new BigDecimal(BigInteger.ZERO);
        bills.stream().forEach(b -> dec.add(b.getTotal()));
        return dec;
    }

    public void addBill(Bill b) {
        this.bills.add(b);
    }

    @Override
    public String toString() {
        return "Customer{" + "bankDetail=" + bankDetail + ", bills=" + bills + ", shoppingCart=" + shoppingCart + '}';
    }
}
