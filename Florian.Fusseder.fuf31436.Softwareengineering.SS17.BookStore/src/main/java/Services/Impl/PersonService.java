/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Impl;

import Entitys.Address;
import Entitys.Author;
import Entitys.BankDetail;
import Entitys.Customer;
import Entitys.Person;
import Entitys.ShoppingCart;
import Services.Interfaces.IPersonService;
import Technicals.Repo.BankRepo;
import Technicals.Repo.PersonRepo;
import Technicals.Repo.ShoppingCartRepo;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Florian
 */
@RequestScoped
public class PersonService implements IPersonService {

	@Inject
	private PersonRepo personRepo;

	@Inject
	private BankRepo bankRepo;

	@Inject
	private ShoppingCartRepo shoppingCartRepo;

	public PersonService() {
	}

	@Override
	public Person find(Person person) {
		return (person.getClass() == Author.class)
				? (Author) this.personRepo.findById(person.getID())
				: (Customer) this.personRepo.findById(person.getID());
	}

	@Override
	public Person find(Long Id) {
		return this.personRepo.findById(Id);
	}

	@Override
	public List<Person> findAll() {
		return personRepo.findAll();
	}

	@Transactional(Transactional.TxType.REQUIRED)
	@Override
	public void persist(Person person) {
		this.personRepo.persist(person);
	}

	@Transactional(Transactional.TxType.REQUIRED)
	@Override
	public Customer createCustomer(String firstName, String lastName, Collection<Address> address, BankDetail bankDetail) {
		if (bankDetail.getID() == null) {
			bankRepo.persist(bankDetail);
		}

		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCartRepo.persist(shoppingCart);

		Customer customer = new Customer(firstName, lastName, address);
		customer.setBankDetail(bankDetail);
		customer.setShoppingCart(shoppingCart);

		personRepo.persist(customer);
		shoppingCart.setDeliveryAddress(address.iterator().next());
		return customer;
	}

	@Transactional(Transactional.TxType.REQUIRED)
	@Override
	public Customer createCustomer(String firstName, String lastName, Address address, BankDetail bankDetail) {
		return createCustomer(firstName, lastName, Arrays.asList(address), bankDetail);
	}

	@Transactional(Transactional.TxType.REQUIRED)
	@Override
	public Author createAuthor(String firstName, String lastName, Collection<Address> address) {
		Author author = new Author(firstName, lastName, address);
		personRepo.persist(author);
		return author;
	}

	@Transactional(Transactional.TxType.REQUIRED)
	@Override
	public Author createAuthor(String firstName, String lastName, Address address) {
		return createAuthor(firstName, lastName, new HashSet<>(Arrays.asList(address)));
	}

	@Transactional(Transactional.TxType.REQUIRED)
	@Override
	public Person addAddress(Person person, Address address) {
		person = (Person) this.personRepo.merge(person);
		person.addAddress(address);
		return person;
	}

}
