/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Technicals;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author Florian
 */
@MappedSuperclass
public class StringIdEntity extends SingleIdEntity<String>
{

    @Id
    private String Id;

    public StringIdEntity(String Id)
    {
        this.Id = Id;
    }

    @Override
    public String getID()
    {
        return this.Id;
    }

    public void setId(String Id)
    {
        this.Id = Id;
    }
}
