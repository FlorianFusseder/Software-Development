/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Florian
 */
@Entity
@Table(name = "paperbooks")
public class PaperBook extends Book
{
    @ElementCollection
    private List<Book> copies;
    
    private String location;

    public PaperBook()
    {
    }

    public PaperBook(List<Book> copies, String location, String name, String isbn, Date release, BigDecimal price)
    {
        super(name, isbn, release, price);
        this.copies = copies;
        this.location = location;
    }

    public PaperBook(List<Book> copies, String location, String name, String isbn, Date release, List<Author> author, BigDecimal price)
    {
        super(name, isbn, release, author, price);
        this.copies = copies;
        this.location = location;
    }

    public List<Book> getCopies()
    {
        return copies;
    }

    public void setCopies(List<Book> copies)
    {
        this.copies = copies;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    @Override
    public String toString()
    {
        return super.toString() + " PaperBook{" + "copies=" + copies + ", location=" + location + '}';
    }
}
