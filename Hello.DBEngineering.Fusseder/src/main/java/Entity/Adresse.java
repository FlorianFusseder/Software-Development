/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import Entity.SingleIdEntity;
import javax.persistence.Entity;

/**
 *
 * @author Florian
 */
@Entity
public class Adresse extends SingleIdEntity<Long>
{

    private String Strasse;
    private int Postleitzahl;
    private String Stadt;

    public Adresse()
    {
    }

    public Adresse(String Strasse, int Postleitzahl, String Stadt)
    {
        this.Strasse = Strasse;
        this.Postleitzahl = Postleitzahl;
        this.Stadt = Stadt;
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
        return super.toString() + " Adresse{" + " Strasse=" + Strasse + ", Postleitzahl=" + Postleitzahl + ", Stadt=" + Stadt + '}';
    }    
}
