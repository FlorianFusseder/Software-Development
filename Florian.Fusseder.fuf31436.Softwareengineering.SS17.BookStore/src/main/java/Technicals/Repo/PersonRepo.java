/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Technicals.Repo;

import Entitys.Person;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;

/**
 * Manages all DB related functions for the Person extendes classes
 *
 * @author Florian
 */
@RequestScoped
public class PersonRepo extends SingleEntityRepository<Long, Person> 
		implements Serializable {

	public PersonRepo() {
		super(Person.class);
	}
}
