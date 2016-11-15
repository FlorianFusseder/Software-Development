/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

import Technicals.GeneratedIdEntity;
import Technicals.SingleIdEntity;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * Represents Bankdetails
 *
 * @author Florian
 */
@Entity
//@Table(name = "BankDetails")
public class BankDetail extends GeneratedIdEntity
{

    @NotNull
    private String bic;

    @NotNull
    private String iban;

    /**
     * Creates Bankdetails with empty fields
     */
    public BankDetail()
    {
    }

    /**
     * Creates Bankdetails with given bic and iban
     *
     * @param bic has to be legit bic for a bank
     * @param iban has to be legit iban for a bank account
     */
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
