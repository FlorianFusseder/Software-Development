/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author Florian
 */
@Entity
public abstract class Person extends SingleIdEntity
{
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "adress")
    private Adress adress;

    protected Person()
    {
    }

    protected Person(String name, Adress adress)
    {
        this.name = name;
        this.adress = adress;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Adress getAdress()
    {
        return adress;
    }

    public void setAdress(Adress adress)
    {
        this.adress = adress;
    }

    @Override
    public String toString()
    {
        return "Person{" + "name=" + name + ", adress=" + adress + '}';
    }
}
