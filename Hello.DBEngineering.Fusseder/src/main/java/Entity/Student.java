/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;


import Entity.SingleIdEntity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


/**
 *
 * @author Florian
 */
@Entity
public class Student extends SingleIdEntity<Long>
{
    private String VorName;
    private String NachName;
    @OneToOne
    private Adresse Adresse;
    private Email EmailAdresse;
    @ManyToOne
    private Professor ErstPruefer;
    @ManyToOne
    private Professor ZweitPruefer;

    public Student()
    {
        this.ErstPruefer = null;
        this.ZweitPruefer = null;
    }
    
        public Student(String VorName, String NachName, Adresse Adresse, Email EmailAdresse)
    {
        this();
        this.VorName = VorName;
        this.NachName = NachName;
        this.Adresse = Adresse;
        this.EmailAdresse = EmailAdresse;
    } 

    public Student(String VorName, String NachName, Adresse Adresse, Email EmailAdresse, Professor ErstPruefer, Professor ZweitPruefer)
    {
        this();
        this.VorName = VorName;
        this.NachName = NachName;
        this.Adresse = Adresse;
        this.EmailAdresse = EmailAdresse;
        this.ErstPruefer = ErstPruefer;
        this.ZweitPruefer = ZweitPruefer;
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

    
    @Override
    public String toString()
    {
        return super.toString() + " Student{" + "VorName=" + VorName + ", NachName=" + NachName + ", Adresse=" + Adresse + ", EmailAdresse=" + EmailAdresse + ", ErstPruefer=" + ErstPruefer + ", ZweitPruefer=" + ZweitPruefer + '}';
    }

    
}
