/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Entitys.Customer;
import Services.PersonService;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.convert.CustomerConverter;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Florian
 */
@Named
@NoArgsConstructor
@ManagedBean
@ApplicationScoped
public class LogInModel implements Serializable {

	@Inject
	private PersonService personManager;

	@Inject
	@Getter
	@Setter
	private CustomerConverter converter;

	@Getter
	@Setter
	private Customer choosenCustomer;

	public List<Customer> GetCustomerList() {
		List<Customer> customerList = personManager.findAll()
				.stream()
				.filter(p -> p.getClass() == Customer.class)
				.map(p -> (Customer) p)
				.collect(Collectors.toList());

		if (!customerList.isEmpty() && this.choosenCustomer == null) {
			this.choosenCustomer = customerList.get(0);
		}
		return customerList;
	}

}
