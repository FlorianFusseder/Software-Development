/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Annotations.PersonAnnotation;
import Entitys.Address;
import Entitys.BankDetail;
import Services.Impl.PersonService;
import Services.Interfaces.IPersonService;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
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
@ManagedBean
@Getter
@Setter
public class CreateCustomerModel implements Serializable {

	@Inject
	@PersonAnnotation
	private IPersonService personService;

	private String firstName;

	private String lastName;

	private String street;

	private String city;

	private String postNumber;
	
	private String iban;
	
	private String bic;

	public String  createCustomer() {
		this.personService.createCustomer(this.firstName, this.lastName,
				new Address(this.street, this.city, Integer.valueOf(this.postNumber)),
				new BankDetail(this.bic, this.iban));
		
		return "login";
	}

}
