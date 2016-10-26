/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author Florian
 */
@Entity
public class Professor extends Person implements Serializable
{
   //@ElementCollection
    @OneToMany(mappedBy = "ErstPruefer")
    private ArrayList<Student> BachelorPruefer;
    //@ElementCollection
    @OneToMany(mappedBy = "ZweitPruefer")
    private ArrayList<Student> BachelorZweitPruefer;

    public Professor()
    {
    }

    public Professor(long Id, String VorName, String NachName, Adresse Adresse, Email EmailAdresse, ArrayList<Student> BachelorPruefer, ArrayList<Student> BachelorZweitPruefer)
    {
        super(Id, VorName, NachName, Adresse, EmailAdresse);
        this.BachelorPruefer = BachelorPruefer;
        this.BachelorZweitPruefer = BachelorZweitPruefer;
    }

    public ArrayList<Student> getBachelorPruefer()
    {
        return BachelorPruefer;
    }

    public void setBachelorPruefer(ArrayList<Student> BachelorPruefer)
    {
        this.BachelorPruefer = BachelorPruefer;
    }

    public ArrayList<Student> getBachelorZweitPruefer()
    {
        return BachelorZweitPruefer;
    }

    public void setBachelorZweitPruefer(ArrayList<Student> BachelorZweitPruefer)
    {
        this.BachelorZweitPruefer = BachelorZweitPruefer;
    }

    @Override
    public String toString()
    {
        return super.toString() + "Professor{" + "BachelorPruefer=" + BachelorPruefer + ", BachelorZweitPruefer=" + BachelorZweitPruefer + '}';
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
