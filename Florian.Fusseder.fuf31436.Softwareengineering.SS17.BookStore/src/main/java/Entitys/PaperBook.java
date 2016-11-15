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
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * Creates a Paperbook object
 * 
 * @author Florian
 */
@Entity
public class PaperBook extends AbstractBook
{
    @OneToMany
    private List<PBookData> copies;

    /**
     * Creates a Paperbook object with empty Copies
     */
    public PaperBook()
    {
        this.copies = new ArrayList<>();
    }

    /**
     * Creates a Paperbook object with given fields
     * 
     * @param name
     * @param isbn
     * @param release
     * @param price
     * @param copies 
     */
    public PaperBook( String name, String isbn, Date release, BigDecimal price, List<PBookData> copies)
    {
        super(name, isbn, release, price);
        this.copies = copies;
    }

    public void setCopies(List<PBookData> copies)
    {
        this.copies = copies;
    }

    public List<PBookData> getCopies()
    {
        return Collections.unmodifiableList(copies);
    }
    
    @Override
    public String toString()
    {
        return "PaperBook{" + "copies=" + copies + "}";
    }
}
