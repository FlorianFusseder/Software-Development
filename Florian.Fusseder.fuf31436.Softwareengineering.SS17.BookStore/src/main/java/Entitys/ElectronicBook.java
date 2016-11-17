/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;

/**
 * Creates a E-AbstractBook
 *
 * @author Florian
 */
@Entity
public class ElectronicBook extends AbstractBook {

    //todo: machste mal mit übergebenen autor in den constructoren wa
    private String license;

    /**
     * Create a empty E-AbstractBook
     */
    public ElectronicBook() {
    }

    public ElectronicBook(String name, String isbn, Date release, BigDecimal price, String license) {
        super(name, isbn, release, price);
        this.license = license;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    @Override
    public String toString() {
        return super.toString() + " ElectronicBook{" + "license=" + license + '}';
    }
}
