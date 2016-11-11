/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

import java.math.BigDecimal;
import java.util.ArrayList;
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
 *
 * @author Florian
 */
@Entity
@Table(name = "bills")
class Bill extends SingleIdEntity<Long>
{
    
    private BigDecimal total;
 
    @Temporal(TemporalType.TIMESTAMP)
    private Date buyingDate;
    
    private Customer customer;
    
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Book> books;

    public Bill()
    {
        this.total = BigDecimal.valueOf(0);
        this.books = new ArrayList<>();
    }

    public Bill(BigDecimal total, Date buyingDate, Customer customer)
    {
        this();
        this.total = total;
        this.buyingDate = buyingDate;
        this.customer = customer;
    }

    public List<Book> getBooks()
    {
        return Collections.unmodifiableList(books);
    }

    public void setBooks(List<Book> books)
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
