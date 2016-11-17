/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entitys.Author;
import Entitys.Customer;
import Entitys.Person;
import Technicals.Repo.PersonRepo;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 *
 * @author Florian
 */
@Transactional(Transactional.TxType.REQUIRED)
public class PersonService {

    @Inject
    private PersonRepo personRepo;

    public PersonService() {
    }

    public void persist(Person person) {
        this.personRepo.persist(person);
    }

    public Person find(Person person) {
        return (person.getClass() == Author.class)
                ? (Author) this.personRepo.findById(person.getID())
                : (Customer) this.personRepo.findById(person.getID());
    }

}
