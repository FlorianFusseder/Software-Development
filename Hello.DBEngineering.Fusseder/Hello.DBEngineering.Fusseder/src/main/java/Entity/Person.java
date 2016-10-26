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
public abstract class Person
{
    @Id
    @GeneratedValue
    private long Id;
    
    private String VorName;
    private String NachName;
    private Adresse Adresse;
    private Email EmailAdresse;

    public Person()
    {
    }
    
    public Person(long Id, String VorName, String NachName, Adresse Adresse, Email EmailAdresse)
    {
        this.Id = Id;
        this.VorName = VorName;
        this.NachName = NachName;
        this.Adresse = Adresse;
        this.EmailAdresse = EmailAdresse;
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

    @Override
    public String toString()
    {
        return "Student{" + "Id=" + Id + ", VorName=" + VorName + ", NachName=" + NachName + ", Adresse=" + Adresse + ", EmailAdresse=" + EmailAdresse + '}';
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 37 * hash + (int) (this.Id ^ (this.Id >>> 32));
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
        if (this.Id != other.getId())
        {
            return false;
        }
        return true;
    }
    
    
    
    
    
    
}

