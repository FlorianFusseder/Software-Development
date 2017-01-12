/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Person;

import Annotations.CustomerAnnotation;
import Entitys.Customer;
import Entitys.ShoppingCart;
import java.util.List;
import java.util.stream.Collectors;
import javax.enterprise.context.RequestScoped;
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

	@Override
	public List<Customer> findAll() {
		return this.getPersonRepo().findAll().stream()
				.filter(p -> p.getClass() == Customer.class)
				.map(p -> (Customer) p)
				.collect(Collectors.toList());
	}

	@Transactional(Transactional.TxType.REQUIRED)
	@Override
	public Customer create(Customer person) {

		this.getBankRepo().persist(person.getBankDetail());

		this.getShoppingCartRepo().persist(person.getShoppingCart());

		this.getPersonRepo().persist(person);
		person.getShoppingCart().setDeliveryAddress(person.getAddress().iterator().next());
		return person;
	}

}
