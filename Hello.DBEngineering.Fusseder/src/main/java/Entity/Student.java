/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Florian
 */
@Entity
public class Student extends Person implements Serializable
{
    private Professor ErstPruefer;
    private Professor ZweitPruefer;

    public Student()
    {
    }

    public Student(long Id, String VorName, String NachName, Adresse Adresse, Email EmailAdresse, Professor Erstpruefer, Professor ZweitPruefer)
    {
        super(Id, VorName, NachName, Adresse, EmailAdresse);
        this.ErstPruefer = Erstpruefer;
        this.ZweitPruefer = ZweitPruefer;
    }

    public Professor getErstPruefer()
    {
        return ErstPruefer;
    }

    public void setErstPruefer(Professor ErstPruefer)
    {
        this.ErstPruefer = ErstPruefer;
    }

    public Professor getZweitPruefer()
    {
        return ZweitPruefer;
    }

    public void setZweitPruefer(Professor ZweitPruefer)
    {
        this.ZweitPruefer = ZweitPruefer;
    }

    @Override
    public String toString()
    {
        return super.toString() + " Student{" + "Erstpruefer=" + ErstPruefer + ", ZweitPruefer=" + ZweitPruefer + '}';
    }

    @Override
    public int hashCode()
    {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj)
    {
        return super.equals(obj);
    }
    
    
    
    
    
    
}
