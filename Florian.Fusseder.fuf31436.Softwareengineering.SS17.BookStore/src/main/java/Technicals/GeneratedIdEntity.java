/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Technicals;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author Florian
 */
@MappedSuperclass
public class GeneratedIdEntity extends SingleIdEntity<Long>
{

    @Id
    @GeneratedValue
    private Long Id;

    @Override
    public Long getID()
    {
        return Id;
    }
    
}
