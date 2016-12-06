/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entitys.Adress;
import Entitys.Author;
import Entitys.BankDetail;
import Entitys.Customer;
import Entitys.Person;
import Entitys.ShoppingCart;
import Technicals.Repo.BankRepo;
import Technicals.Repo.PersonRepo;
import Technicals.Repo.ShoppingCartRepo;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Florian
 */
@RequestScoped
public class PersonService implements Serializable {

	@Inject
	private PersonRepo personRepo;

	@Inject
	private BankRepo bankRepo;

	@Inject
	private ShoppingCartRepo shoppingCartRepo;

	public PersonService() {
	}

	@Transactional(Transactional.TxType.REQUIRED)
	public void persist(Person person) {
		this.personRepo.persist(person);
	}

	public Person find(Person person) {
		return (person.getClass() == Author.class)
				? (Author) this.personRepo.findById(person.getID())
				: (Customer) this.personRepo.findById(person.getID());
	}
	
	public Person find(Long Id){
		return this.personRepo.findById(Id);
	}
	
	public List<Person> findAll() {
		return personRepo.findAll();
	}

	@Transactional(Transactional.TxType.REQUIRED)
	public Customer createCustomer(String firstName, String lastName, Adress adress, BankDetail bankDetail) {
		if (bankDetail.getID() == null) {
			bankRepo.persist(bankDetail);
		}

		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCartRepo.persist(shoppingCart);

		Customer customer = new Customer(firstName, lastName, adress);
		customer.setBankDetail(bankDetail);
		customer.setShoppingCart(shoppingCart);

		personRepo.persist(customer);
		return customer;
	}

	@Transactional(Transactional.TxType.REQUIRED)
	public Author createAuthor(String firstName, String lastName, Adress address) {
		Author author = new Author(firstName, lastName, address);
		personRepo.persist(author);
		return author;
	}
}
