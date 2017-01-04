/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Entitys.Address;
import Services.Interfaces.IPersonService;
import java.io.Serializable;
import javax.annotation.PostConstruct;
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
public class CreateAuthorModel implements Serializable {

	@Inject
	private IPersonService personService;

	private String firstName;

	private String lastName;

	private String street;

	private String city;

	private String postNumber;
	
	private String log;
	
	@PostConstruct
	public void init(){
		log = "";
	}

	public void createAuthor() {
		this.personService.createAuthor(this.firstName, this.lastName,
				new Address(this.street, this.city, Integer.valueOf(this.postNumber)));
		
		log += "New Author: " +  this.firstName
				+ " " + this.lastName
				+ " " + this.street
				+ " " + this.city
				+ " " + this.postNumber + "\n";
		
		this.firstName = "";
		this.lastName = "";
		this.street = "";
		this.city = "";
		this.postNumber = "";
	}

}
