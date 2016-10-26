/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Florian
 */
@Entity
public class Professor implements Serializable
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
    @ElementCollection
    @OneToMany(mappedBy = "ErstPruefer")
    private ArrayList<Student> BachelorPruefer;
    @ElementCollection
    @OneToMany(mappedBy = "ZweitPruefer")
    private ArrayList<Student> BachelorZweitPruefer;

    public Professor()
    {
    }

    public Professor(String VorName, String NachName, Adresse Adresse, Email EmailAdresse, ArrayList<Student> BachelorPruefer, ArrayList<Student> BachelorZweitPruefer)
    {
        this.VorName = VorName;
        this.NachName = NachName;
        this.Adresse = Adresse;
        this.EmailAdresse = EmailAdresse;
        this.BachelorPruefer = BachelorPruefer;
        this.BachelorZweitPruefer = BachelorZweitPruefer;
    }
    
    

    public Professor(long Id, String VorName, String NachName, Adresse Adresse, Email EmailAdresse, ArrayList<Student> BachelorPruefer, ArrayList<Student> BachelorZweitPruefer)
    {
        this.Id = Id;
        this.VorName = VorName;
        this.NachName = NachName;
        this.Adresse = Adresse;
        this.EmailAdresse = EmailAdresse;
        this.BachelorPruefer = BachelorPruefer;
        this.BachelorZweitPruefer = BachelorZweitPruefer;
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
    public int hashCode()
    {
        int hash = 7;
        hash = 89 * hash + (int) (this.Id ^ (this.Id >>> 32));
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
        final Professor other = (Professor) obj;
        if (this.Id != other.Id)
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "Professor{" + "Id=" + Id + ", VorName=" + VorName + ", NachName=" + NachName + ", Adresse=" + Adresse + ", EmailAdresse=" + EmailAdresse + ", BachelorPruefer=" + BachelorPruefer + ", BachelorZweitPruefer=" + BachelorZweitPruefer + '}';
    }    
    
}
