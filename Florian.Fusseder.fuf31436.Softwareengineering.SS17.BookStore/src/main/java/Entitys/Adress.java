/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotNull;

/**
 * Represents an Adress
 * 
 * @author Florian
 */
@Embeddable
public class Adress implements Serializable
{
    @NotNull
    private String street;
    
    @NotNull
    private String city;
    
    @NotNull
    private int postNumber;

    /**
     * Creates an Adress with empty fields
     */
    public Adress()
    {
    }
    
    /**
     * Creates an Adress with given fields
     * @param street Name of the street
     * @param city Name of the city
     * @param postNumber postnumber has do be 5 digits long to be legit
     */
    public Adress(String street, String city, int postNumber)
    {
        this.street = street;
        this.city = city;
        this.postNumber = postNumber;
    }
    
    @PreUpdate
    @PrePersist
    /**
     * Checks for legit data in the street, city and postnumber fields. Is PreUpdate and PrePresist Annotated
     */
    private void checkLegit(){
        if(street.isEmpty() || city.isEmpty() || String.valueOf(postNumber).length() != 5)
            throw new IllegalArgumentException("Adress value had a wrong Format:\n" + this.toString());
    }

    public String getStreet()
    {
        return street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public int getPostNumber()
    {
        return postNumber;
    }

    public void setPostNumber(int postNumber)
    {
        this.postNumber = postNumber;
    }

    @Override
    public String toString()
    {
        return super.toString() + " Adress{" + "street=" + street + ", city=" + city + ", postNumber=" + postNumber + '}';
    }
}
