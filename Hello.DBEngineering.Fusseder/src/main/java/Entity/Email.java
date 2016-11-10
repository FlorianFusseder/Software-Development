/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Florian
 */
@Embeddable
public class Email implements Serializable
{
    private String EmailAdresse;

    public Email()
    {
    }

    public Email(String Adresse)
    {
        this.EmailAdresse = Adresse;
    }

    public String getEmailAdresse()
    {
        return EmailAdresse;
    }

    public void setEmailAdresse(String EmailAdresse)
    {
        this.EmailAdresse = EmailAdresse;
    }

    @Override
    public String toString()
    {
        return "Email{" + "Adresse=" + EmailAdresse + '}';
    }
  
}
