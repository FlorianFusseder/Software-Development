/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

import javax.persistence.Entity;

/**
 * Creates a PaperBookData object whitch hold the location of the Book and the status
 * 
 * @author Florian
 */
@Entity
public class PBookData extends SingleIdEntity<Long>
{
    private String location;
    private String status;

    /**
     * Creates a empty PBookData object
     */
    public PBookData()
    {
    }

    /**
     * Creates a PBookData object with the given fields
     * 
     * @param location
     * @param status 
     */
    public PBookData(String location, String status)
    {
        this.location = location;
        this.status = status;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return "PBookData{" + "location=" + location + ", status=" + status + '}';
    }
}
