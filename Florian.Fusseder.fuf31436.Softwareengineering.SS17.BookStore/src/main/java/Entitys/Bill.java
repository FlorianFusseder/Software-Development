/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

import Technicals.GeneratedIdEntity;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Represents a Bill for a AbstractBook
 *
 * @author Florian
 */
@Entity
@Table(name = "bills")
public class Bill extends GeneratedIdEntity
{

    private BigDecimal total;

    @Temporal(TemporalType.TIMESTAMP)
    private Date buyingDate;

    private Customer customer;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<AbstractBook> books;

    /**
     * Creates a Bill with empty fields
     */
    public Bill()
    {
    }

    /**
     * Creates a Bill with the given customer and a ArrayList of books.
     * Timestamp and total price will be automatically filled in
     *
     * @param customer Customer that owns the Bill
     * @param books List of bought books
     */
    public Bill(Customer customer, List<AbstractBook> books)
    {
        this.buyingDate = new Date();
        this.customer = customer;
        this.books = books;
        this.total = new BigDecimal(BigInteger.ZERO);
        if (this.books != null)
        {
            for (AbstractBook book : books)
            {
                BigDecimal dd = book.getPrice();
                this.total = this.total.add(dd);
            }
}
    }

    public List<AbstractBook> getBooks()
    {
        return Collections.unmodifiableList(books);
    }

    public void setBooks(List<AbstractBook> books)
    {
        this.books = books;
    }

    public BigDecimal getTotal()
    {
        return total;
    }

    public void setTotal(BigDecimal total)
    {
        this.total = total;
    }

    public Date getBuyingDate()
    {
        return buyingDate;
    }

    public void setBuyingDate(Date buyingDate)
    {
        this.buyingDate = buyingDate;
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
        return super.toString() + " Bill{" + "books=" + books + ", total=" + total + ", buyingDate=" + buyingDate + ", customer=" + customer + '}';
    }
}
