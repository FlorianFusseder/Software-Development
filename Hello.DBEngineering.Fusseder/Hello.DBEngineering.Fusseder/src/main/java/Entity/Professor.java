/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.ArrayList;
import javax.persistence.ElementCollection;

/**
 *
 * @author Florian
 */
public class Professor extends Person
{
    @ElementCollection
    private ArrayList<Student> BachelorPruefer;
    @ElementCollection
    private ArrayList<Student> BachelorZweitPruefer;

    public Professor()
    {
    }

    public Professor(ArrayList<Student> BachelorPruefer, ArrayList<Student> BachelorZweitPruefer, long Id, String VorName, String NachName, Adresse Adresse, Email EmailAdresse)
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
    
    
    
}
