/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import Entity.SingleIdEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Florian
 */
@Entity
public class Professor extends SingleIdEntity<Long>
{

    private String VorName;
    private String NachName;
    @OneToOne
    private Adresse Adresse;
    private Email EmailAdresse;
    @OneToMany(mappedBy = "ErstPruefer")
    private Collection<Student> BachelorPruefer;
    @OneToMany(mappedBy = "ZweitPruefer")
    private Collection<Student> BachelorZweitPruefer;

    public Professor()
    {
        this.BachelorPruefer = new ArrayList<>();
        this.BachelorZweitPruefer = new ArrayList<>();
    }

    public Professor(String VorName, String NachName, Adresse Adresse, Email EmailAdresse)
    {
        this();
        this.VorName = VorName;
        this.NachName = NachName;
        this.Adresse = Adresse;
        this.EmailAdresse = EmailAdresse;
    }

    public Professor(String VorName, String NachName, Adresse Adresse, Email EmailAdresse, Collection<Student> BachelorPruefer, Collection<Student> BachelorZweitPruefer)
    {
        this();
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

    public Collection<Student> getBachelorPruefer()
    {
        return Collections.unmodifiableCollection(BachelorPruefer);
    }

    public void addBachelorPruefer(Student s)
    {
        this.BachelorPruefer.add(s);
    }

    public void setBachelorPruefer(ArrayList<Student> BachelorPruefer)
    {
        this.BachelorPruefer = BachelorPruefer;
    }

    public Collection<Student> getBachelorZweitPruefer()
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
