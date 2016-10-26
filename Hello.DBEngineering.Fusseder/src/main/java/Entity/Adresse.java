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
public class Adresse
{
    @Id
    @GeneratedValue
    private long Id;
    private String StrassenName;
    private String Strasse;
    private int Postleitzahl;
    private String Stadt;

    public Adresse()
    {
    }

    public Adresse(long Id, String StrassenName, String Strasse, int Postleitzahl, String Stadt)
    {
        this.Id = Id;
        this.StrassenName = StrassenName;
        this.Strasse = Strasse;
        this.Postleitzahl = Postleitzahl;
        this.Stadt = Stadt;
    }

    public long getId()
    {
        return Id;
    }

    public void setId(long Id)
    {
        this.Id = Id;
    }

    public String getStrassenName()
    {
        return StrassenName;
    }

    public void setStrassenName(String StrassenName)
    {
        this.StrassenName = StrassenName;
    }

    public String getStrasse()
    {
        return Strasse;
    }

    public void setStrasse(String Strasse)
    {
        this.Strasse = Strasse;
    }

    public int getPostleitzahl()
    {
        return Postleitzahl;
    }

    public void setPostleitzahl(int Postleitzahl)
    {
        this.Postleitzahl = Postleitzahl;
    }

    public String getStadt()
    {
        return Stadt;
    }

    public void setStadt(String Stadt)
    {
        this.Stadt = Stadt;
    }

    @Override
    public String toString()
    {
        return "Adresse{" + "Id=" + Id + ", StrassenName=" + StrassenName + ", Strasse=" + Strasse + ", Postleitzahl=" + Postleitzahl + ", Stadt=" + Stadt + '}';
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 23 * hash + (int) (this.Id ^ (this.Id >>> 32));
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
        final Adresse other = (Adresse) obj;
        if (this.Id != other.Id)
        {
            return false;
        }
        return true;
    }

    
    
    
    
}
