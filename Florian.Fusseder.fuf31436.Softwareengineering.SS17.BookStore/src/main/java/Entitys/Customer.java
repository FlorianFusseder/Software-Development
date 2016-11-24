/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

import java.math.BigDecimal;
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

    @OneToMany(cascade = CascadeType.ALL)
    private List<ShoppingCart> payedShoppingCarts;

    @OneToOne
    private ShoppingCart shoppingCart;

    /**
     * Creates a customer with empty fields and initializes a empty List of Bill
     * and a ShoppingCart
     */
    public Customer() {
        this.payedShoppingCarts = new ArrayList<>();
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
        this.payedShoppingCarts = new ArrayList<>();
    }

    /**
     * Creates a customer with given fieldes
     *
     * @param firstName
     * @param lastName
     * @param adress
     * @param bankDetail
     * @param payedShoppingCarts
     */
    public Customer(String firstName, String lastName, Adress adress, BankDetail bankDetail, List<ShoppingCart> payedShoppingCarts) {
        super(firstName, lastName, adress);
        this.bankDetail = bankDetail;
        this.payedShoppingCarts = payedShoppingCarts;
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

    public List<ShoppingCart> getShoppingCarts() {
        return Collections.unmodifiableList(payedShoppingCarts);
    }

    public void setShoppingCarts(List<ShoppingCart> payedShoppingCarts) {
        this.payedShoppingCarts = payedShoppingCarts;
    }
	
	public void addPayedShoppingCart(ShoppingCart shoppingCart){
		this.payedShoppingCarts.add(shoppingCart);
	}

    public BigDecimal getTotalPayment() {
        return this.payedShoppingCarts.stream()
				.map(e -> e.getTotal())
				.reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public String toString() {
        return "Customer{" + "bankDetail=" + bankDetail + ", bills=" + payedShoppingCarts + ", shoppingCart=" + shoppingCart + '}';
    }
}
