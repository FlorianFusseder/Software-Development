/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Null;

/**
 *
 * @author Florian
 */
@Entity
public class Student implements Serializable
{
    @Id
    @GeneratedValue
    private long Id;
    private String VorName;
    private String NachName;
    @OneToOne
    private Adresse Adresse;
    @OneToOne
    private Email EmailAdresse;
    @OneToOne
    private Professor ErstPruefer;
    @OneToOne
    private Professor ZweitPruefer;

    public Student()
    {
    }

    public Student(String VorName, String NachName, Adresse Adresse, Email EmailAdresse, Professor ErstPruefer, Professor ZweitPruefer)
    {
        this.VorName = VorName;
        this.NachName = NachName;
        this.Adresse = Adresse;
        this.EmailAdresse = EmailAdresse;
        this.ErstPruefer = ErstPruefer;
        this.ZweitPruefer = ZweitPruefer;
    }

    public Student(long Id, String VorName, String NachName, Adresse Adresse, Email EmailAdresse, Professor ErstPruefer, Professor ZweitPruefer)
    {
        this.Id = Id;
        this.VorName = VorName;
        this.NachName = NachName;
        this.Adresse = Adresse;
        this.EmailAdresse = EmailAdresse;
        this.ErstPruefer = ErstPruefer;
        this.ZweitPruefer = ZweitPruefer;
    }    

    public long getId()
    {
        return Id;
    }

    public void setId(long Id)
    {
        this.Id = Id;
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
        return ZweitPruefer;
    }

    public void setZweitPruefer(Professor ZweitPruefer)
    {
        this.ZweitPruefer = ZweitPruefer;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 17 * hash + (int) (this.Id ^ (this.Id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Student other = (Student) obj;
        if (this.Id != other.Id)
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "Student{" + "Id=" + Id + ", VorName=" + VorName + ", NachName=" + NachName + ", Adresse=" + Adresse + ", EmailAdresse=" + EmailAdresse + ", ErstPruefer=" + ErstPruefer + ", ZweitPruefer=" + ZweitPruefer + '}';
    }
}
