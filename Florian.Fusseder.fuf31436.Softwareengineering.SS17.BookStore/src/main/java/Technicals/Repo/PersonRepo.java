/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Technicals.Repo;

import Entitys.Person;

/**
 *
 * @author Florian
 */
/**
 * Manages all DB related functions for the Person extendes classes
 *
 * @author Florian
 */
public class PersonRepo extends SingleEntityRepository<Long, Person> {

    public PersonRepo() {
        super(Person.class);
    }
}
