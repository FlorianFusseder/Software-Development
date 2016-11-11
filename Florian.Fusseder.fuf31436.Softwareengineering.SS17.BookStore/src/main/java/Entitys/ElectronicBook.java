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
 *
 * @author Florian
 */
@Entity
public class ElectronicBook extends Book
{
    private String license;

    public ElectronicBook()
    {
    }

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
