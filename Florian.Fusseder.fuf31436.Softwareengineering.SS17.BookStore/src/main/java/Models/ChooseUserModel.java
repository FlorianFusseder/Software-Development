/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Entitys.Customer;
import Services.PersonService;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Florian
 */
@ToString
@Named
@NoArgsConstructor
@RequestScoped
public class ChooseUserModel implements Serializable{
	
	
	@Inject
	private PersonService personManager;
	

	private Map<String, Customer> customerMap;
	
	@Getter
	@Setter
	private Customer choosenCustomer;

	public Map<String, Customer> getCumstomerMap() {
		this.customerMap = personManager.findAll()
						.stream()
						.filter(p -> p.getClass() == Customer.class)
						.map(p -> (Customer) p)
						.collect(Collectors.toMap(c -> c.toString(), c -> c));
		
		this.choosenCustomer = customerMap.entrySet().iterator().next().getValue();
		return customerMap;
	}
	
	
}
