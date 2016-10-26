/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Objects;
import javax.persistence.Embeddable;

/**
 *
 * @author Florian
 */
@Embeddable
public class Email
{
    private String Adresse;

    public Email()
    {
    }

    public Email(String Adresse)
    {
        this.Adresse = Adresse;
    }

    public String getAdresse()
    {
        return Adresse;
    }

    public void setAdresse(String Adresse)
    {
        this.Adresse = Adresse;
    }

    @Override
    public String toString()
    {
        return "Email{" + "Adresse=" + Adresse + '}';
    }
  
}
