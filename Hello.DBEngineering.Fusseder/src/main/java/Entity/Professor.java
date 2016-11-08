/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import javax.persistence.CascadeType;
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
public class Professor extends SingleIdEntity
{

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

    public Professor(String VorName, String NachName, Adresse Adresse, Email EmailAdresse)
    {
        this.VorName = VorName;
        this.NachName = NachName;
        this.Adresse = Adresse;
        this.EmailAdresse = EmailAdresse;
        this.BachelorPruefer = new ArrayList<>();
        this.BachelorZweitPruefer = new ArrayList<>();
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

    public void addBachelorPruefer(Student s)
    {
        this.BachelorPruefer.add(s);
    }

    public void setBachelorPruefer(ArrayList<Student> BachelorPruefer)
    {
        this.BachelorPruefer = BachelorPruefer;
    }

    public ArrayList<Student> getBachelorZweitPruefer()
    {
        return BachelorZweitPruefer;
    }

    public void addBachelorZweitPruefer(Student s)
    {
        this.BachelorPruefer.add(s);
    }

    public void setBachelorZweitPruefer(ArrayList<Student> BachelorZweitPruefer)
    {
        this.BachelorZweitPruefer = BachelorZweitPruefer;
    }

    @Override
    public String toString()
    {
        return super.toString() + " Professor{" + "VorName=" + VorName + ", NachName=" + NachName + ", Adresse=" + Adresse + ", EmailAdresse=" + EmailAdresse + ", BachelorPruefer=" + BachelorPruefer + ", BachelorZweitPruefer=" + BachelorZweitPruefer + '}';
    }

}
