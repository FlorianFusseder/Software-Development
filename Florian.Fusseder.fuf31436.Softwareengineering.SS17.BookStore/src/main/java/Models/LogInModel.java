/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Entitys.Customer;
import Services.PersonService;
import java.io.Serializable;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
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

	@Setter
	private Map<String, Customer> customerMap;

	@Getter
	@Setter
	private Customer choosenCustomer;

	@PostConstruct
	public void setData() {
		this.customerMap = personManager.findAll()
				.stream()
				.filter(p -> p.getClass() == Customer.class)
				.map(p -> (Customer) p)
				.collect(Collectors.toMap(c -> c.getFirstName() + " " + c.getLastName(), c -> c));

		this.choosenCustomer = this.customerMap.entrySet().iterator().next().getValue();
	}

	public Map<String, Customer> getCumstomerMap() {
		this.setData();
		return this.customerMap;
	}

}
