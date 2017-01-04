/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Interfaces;

import Entitys.Address;
import Entitys.Author;
import Entitys.BankDetail;
import Entitys.Customer;
import Entitys.Person;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Florian
 */
public interface IPersonService extends Serializable {

	public Person find(Person person);

	public Person find(Long Id);

	public List<Person> findAll();

	public void persist(Person person);

	public Customer createCustomer(String firstName, String lastName, Collection<Address> address, BankDetail bankDetail);

	public Customer createCustomer(String firstName, String lastName, Address address, BankDetail bankDetail);

	public Author createAuthor(String firstName, String lastName, Collection<Address> address);

	public Author createAuthor(String firstName, String lastName, Address address);

	public Person addAddress(Person person, Address address);

}
