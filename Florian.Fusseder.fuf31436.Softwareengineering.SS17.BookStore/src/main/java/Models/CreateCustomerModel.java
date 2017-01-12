/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Annotations.CustomerAnnotation;
import Entitys.Address;
import Entitys.BankDetail;
import Entitys.Customer;
import Services.Interfaces.IPersonService;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
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
@RequestScoped
@NoArgsConstructor
@Getter
@Setter
public class CreateCustomerModel implements Serializable {

	@Inject
	@CustomerAnnotation
	private IPersonService<Customer> customerService;

	private String firstName;

	private String lastName;

	private String street;

	private String city;

	private String postNumber;

	private String iban;

	private String bic;

	public String createCustomer() {

		Address address = new Address(this.street, this.city, Integer.valueOf(this.postNumber));
		BankDetail bankDetail = new BankDetail(this.bic, this.iban);
		Customer customer = new Customer(this.firstName, this.lastName, address, bankDetail);
		this.customerService.create(customer);

		return "login";
	}

}
