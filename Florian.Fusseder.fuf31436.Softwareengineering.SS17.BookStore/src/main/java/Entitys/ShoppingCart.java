/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

import Technicals.Id.GeneratedIdEntity;
import java.util.List;
import javax.persistence.Entity;

/**
 *
 * @author Florian
 */
@Entity
public class ShoppingCart extends GeneratedIdEntity
{
    private List<AbstractBook> items;
    private Customer customer;

    public ShoppingCart()
    {
    }

    public ShoppingCart(List<AbstractBook> items, Customer customer)
    {
        this.items = items;
        this.customer = customer;
    }

    public List<AbstractBook> getItems()
    {
        return items;
    }

    public void setItems(List<AbstractBook> items)
    {
        this.items = items;
    }

    public Customer getCustomer()
    {
        return customer;
    }

    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }

    @Override
    public String toString()
    {
        return "ShoppingCart{" + "items=" + items + ", customer=" + customer + '}';
    }
}
