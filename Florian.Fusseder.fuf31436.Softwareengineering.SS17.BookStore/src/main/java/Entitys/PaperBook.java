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
 * Creates a Paperbook object
 *
 * @author Florian
 */
@Entity
public class PaperBook extends AbstractBook {

    private long copies;

    /**
     * Creates a Paperbook object with empty Copies
     */
    public PaperBook() {
    }

    /**
     *
     * @param name
     * @param isbn
     * @param release
     * @param price
     * @param copies
     */
    public PaperBook(String name, String isbn, Date release, BigDecimal price, long copies) {
        super(name, isbn, release, price);
        this.copies = copies;
    }

    public long getCopies() {
        return copies;
    }

    public void setCopies(Long copies) {
        this.copies = copies;
    }

    @Override
    public String toString() {
        return super.toString() + " PaperBook{" + "copies=" + copies + "}";
    }
}
