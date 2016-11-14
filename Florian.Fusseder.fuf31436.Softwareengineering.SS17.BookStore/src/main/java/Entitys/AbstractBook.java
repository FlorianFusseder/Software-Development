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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Abstract AbstractBook Class
 * @author Florian
 */
@Entity
abstract public class AbstractBook extends SingleIdEntity<Long>
{
    private String name;
    
    private String isbn;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date release;
    
    @ManyToMany(mappedBy = "books", cascade = CascadeType.ALL)
    private List<Author> author;
    
    private BigDecimal price;
    
    protected AbstractBook()
    {
        this.author = new ArrayList<>();
    }

    protected AbstractBook(String name, String isbn, Date release, BigDecimal price)
    {   this();
        this.name = name;
        this.isbn = isbn;
        this.release = release;
        this.price = price;
    }

    protected AbstractBook(String name, String isbn, Date release, List<Author> author, BigDecimal price)
    {
        this.name = name;
        this.isbn = isbn;
        this.release = release;
        this.author = author;
        this.price = price;
    }
    
    
    @PreUpdate
    @PrePersist
    private void checkLegit(){
        //todo ask if regex in annotaion or here and add right regex
        if(false)
            throw new IllegalArgumentException("Adress value had a wrong Format:\n" + this.toString());
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getIsbn()
    {
        return isbn;
    }

    public void setIsbn(String isbn)
    {
        this.isbn = isbn;
    }

    public Date getRelease()
    {
        return release;
    }

    public void setRelease(Date release)
    {
        this.release = release;
    }

    public List<Author> getAuthor()
    {
        return Collections.unmodifiableList(author);
    }

    public void setAuthor(List<Author> author)
    {
        this.author = author;
    }

    public BigDecimal getPrice()
    {
        return price;
    }

    public void setPrice(BigDecimal price)
    {
        this.price = price;
    }

    @Override
    public String toString()
    {
        return super.toString() + " Book{" + "name=" + name + ", isbn=" + isbn + ", release=" + release + ", author=" + author + ", price=" + price + '}';
    }
}
