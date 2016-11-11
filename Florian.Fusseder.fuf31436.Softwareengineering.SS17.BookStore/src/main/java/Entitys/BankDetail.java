/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author Florian
 */
@Entity
@Table(name = "BankDetails")
class BankDetail extends SingleIdEntity<Long>
{

    @NotNull
    private String bic;
    
    @NotNull
    private String iban;

    public BankDetail()
    {
    }

    public BankDetail(String bic, String iban)
    {
        this.bic = bic;
        this.iban = iban;
    }
    
    @PreUpdate
    @PrePersist
    private void checkLegit(){
        //todo ask if regex in annotaion or here!

        if(!this.bic.matches("[a-zA-Z]{4}[a-zA-Z]{2}[a-zA-Z0-9]{2}([a-zA-Z0-9]{3})?") || 
                this.iban.matches("[a-zA-Z]{2}[0-9]{2}[a-zA-Z0-9]{4}[0-9]{7}([a-zA-Z0-9]?){0,16}"))
            throw new IllegalArgumentException("Adress value had a wrong Format:\n" + this.toString());
    }

    public String getBic()
    {
        return bic;
    }

    public void setBic(String bic)
    {
        this.bic = bic;
    }

    public String getIban()
    {
        return iban;
    }

    public void setIban(String iban)
    {
        this.iban = iban;
    }

    @Override
    public String toString()
    {
        return super.toString() + " BankDetail{" + "bic=" + bic + ", iban=" + iban + '}';
    }
    
    
    
}
