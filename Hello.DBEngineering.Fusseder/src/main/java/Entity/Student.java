/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

<<<<<<< HEAD
import Entity.SingleIdEntity;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
=======

import java.util.ArrayList;
import java.util.List;
import javax.persistence.ElementCollection;
>>>>>>> 52fb54bda86e53d2d4e2fa2dd89598f9c2640be9
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


/**
 *
 * @author Florian
 */
@Entity
public class Student extends SingleIdEntity
{
    private String VorName;
    private String NachName;
    @OneToOne
    private Adresse Adresse;
    @OneToOne
    private Email EmailAdresse;
    @ManyToOne
    private Professor ErstPruefer;
    @ManyToOne
    private Professor ZweitPruefer;
    @ManyToMany
    @ElementCollection
    private List<Pruefungen> Pruefungen;

    public Student()
    {
        this.ErstPruefer = null;
        this.ZweitPruefer = null;
        this.Pruefungen = new ArrayList<>();
    }
    
        public Student(String VorName, String NachName, Adresse Adresse, Email EmailAdresse)
    {
        this();
        this.VorName = VorName;
        this.NachName = NachName;
        this.Adresse = Adresse;
        this.EmailAdresse = EmailAdresse;
    } 

    public Student(String VorName, String NachName, Adresse Adresse, Email EmailAdresse, Professor ErstPruefer, Professor ZweitPruefer, ArrayList<Pruefungen> pruefungen)
    {
        this();
        this.VorName = VorName;
        this.NachName = NachName;
        this.Adresse = Adresse;
        this.EmailAdresse = EmailAdresse;
        this.ErstPruefer = ErstPruefer;
        this.ZweitPruefer = ZweitPruefer;
        this.Pruefungen = pruefungen;
    }    

    public String getVorName()
    {
        return VorName;
    }

    public void setVorName(String VorName)
    {
        this.VorName = VorName;
    }

    public String getNachName()
    {
        return NachName;
    }

    public void setNachName(String NachName)
    {
        this.NachName = NachName;
    }

    public Adresse getAdresse()
    {
        return Adresse;
    }

    public void setAdresse(Adresse Adresse)
    {
        this.Adresse = Adresse;
    }

    public Email getEmailAdresse()
    {
        return EmailAdresse;
    }

    public void setEmailAdresse(Email EmailAdresse)
    {
        this.EmailAdresse = EmailAdresse;
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
        return this.ZweitPruefer;
    }

    public void setZweitPruefer(Professor ZweitPruefer)
    {
        this.ZweitPruefer = ZweitPruefer;
    }

    public List<Pruefungen> getPruefungen()
    {
        return Pruefungen;
    }

    public void setPruefungen(List<Pruefungen> Pruefungen)
    {
        this.Pruefungen = Pruefungen;
    }
    
    @Override
    public String toString()
    {
        return super.toString() + " Student{" + "VorName=" + VorName + ", NachName=" + NachName + ", Adresse=" + Adresse + ", EmailAdresse=" + EmailAdresse + ", ErstPruefer=" + ErstPruefer + ", ZweitPruefer=" + ZweitPruefer + '}';
    }

    
}
