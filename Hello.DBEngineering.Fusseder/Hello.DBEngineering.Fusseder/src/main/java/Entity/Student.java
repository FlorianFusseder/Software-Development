/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Florian
 */
@Entity
public class Student extends Person
{
    private Professor Erstpruefer;
    private Professor ZweitPruefer;

    public Student()
    {
    }

    public Student(Professor Erstpruefer, Professor ZweitPruefer, long Id, String VorName, String NachName, Adresse Adresse, Email EmailAdresse)
    {
        super(Id, VorName, NachName, Adresse, EmailAdresse);
        this.Erstpruefer = Erstpruefer;
        this.ZweitPruefer = ZweitPruefer;
    }

    public Professor getErstpruefer()
    {
        return Erstpruefer;
    }

    public void setErstpruefer(Professor Erstpruefer)
    {
        this.Erstpruefer = Erstpruefer;
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
        return super.toString() + " Student{" + "Erstpruefer=" + Erstpruefer + ", ZweitPruefer=" + ZweitPruefer + '}';
    }
    
    
    
    
    
    
}
