/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
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
class BankDetail extends SingleIdEntity
{
    @Pattern(regexp = "[A-Z0-9]")
    @Size(min = 8, max = 11)
    @NotNull
    private String bic;
    
    @Pattern(regexp = "[A-Z0-9]")
    @Size(min = 15, max = 34)
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
