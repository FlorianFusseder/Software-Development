/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;

/**
 * Creates a E-AbstractBook
 * 
 * @author Florian
 */
@Entity
public class ElectronicBook extends AbstractBook
{
    private String license;

    /**
     * Create a empty E-AbstractBook
     */
    public ElectronicBook()
    {
    }

    /**
     * Creates an E-AbstractBook with given fields
     * 
     * @param license
     * @param name
     * @param isbn
     * @param release
     * @param price 
     */
    public ElectronicBook(String license, String name, String isbn, Date release, BigDecimal price)
    {
        super(name, isbn, release, price);
        this.license = license;
    }

    public String getLicense()
    {
        return license;
    }

    public void setLicense(String license)
    {
        this.license = license;
    }

    @Override
    public String toString()
    {
        return super.toString() + " ElectronicBook{" + "license=" + license + '}';
    }
}
