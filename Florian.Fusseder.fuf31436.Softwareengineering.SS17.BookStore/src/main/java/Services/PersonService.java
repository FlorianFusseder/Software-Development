/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Florian
 */
public class PersonService
{
    @PersistenceContext(unitName = "BookStorePU")
    private EntityManager manager;
    
    
}
