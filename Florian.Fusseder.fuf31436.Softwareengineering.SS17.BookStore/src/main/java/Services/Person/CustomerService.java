/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Person;

import Annotations.CustomerAnnotation;
import Entitys.Customer;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import lombok.NoArgsConstructor;

/**
 *
 * @author Florian
 */
@CustomerAnnotation
@RequestScoped
@NoArgsConstructor
public class CustomerService extends PersonService<Customer> {

	@Inject
	private Logger logger;

	@Override
	public List<Customer> findAll() {

		logger.info("Find all customers");
		return this.getPersonRepo().findAll().stream()
				.filter(p -> p.getClass() == Customer.class)
				.map(p -> (Customer) p)
				.collect(Collectors.toList());
	}

	@Transactional(Transactional.TxType.REQUIRED)
	@Override
	public Customer create(Customer person) {
		logger.info("Create a customer");

		this.getBankRepo().persist(person.getBankDetail());

		this.getShoppingCartRepo().persist(person.getShoppingCart());

		this.getPersonRepo().persist(person);
		person.getShoppingCart().setDeliveryAddress(person.getAddress().iterator().next());
		return person;
	}

}
