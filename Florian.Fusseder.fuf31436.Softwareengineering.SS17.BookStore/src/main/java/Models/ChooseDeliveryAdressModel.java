/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Entitys.Address;
import Services.Interfaces.IShoppingService;
import java.util.Collection;
import java.util.logging.Logger;
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
public class ChooseDeliveryAdressModel {
	
	@Inject
	private Logger logger;

	@Inject
	private ShoppingSiteModel siteModel;
	
	@Inject
	private IShoppingService shoppingService;

	@Setter
	@Getter
	private String newStreet;

	@Setter
	@Getter
	private String newCity;

	@Setter
	@Getter
	private Integer newPostNumber;

	@Setter
	@Getter
	private Collection<Address> addresses;

	@Getter
	@Setter
	private Address choosenAddress;

	@PostConstruct
	private void init() {
		logger.info("init ChooseDeliveryAddressModel");
		this.newCity = "";
		this.newStreet = "";
		this.newPostNumber = null;
		this.addresses = siteModel.getCustomer().getAddress();
	}

	public String setDeliveryAddress() {

		logger.info("setDeliveryAddress ChooseDeliveryAddressModel");
		
		Address a = null;
		if (!this.newCity.isEmpty() && !this.newStreet.isEmpty() && this.newPostNumber != null) {
			a = new Address(this.newStreet, this.newCity, this.newPostNumber);
		} else {
			a = choosenAddress;
		}

		this.siteModel.setCustomer(this.shoppingService.setDeliveryAddress(siteModel.getCustomer(), a)); 
		if (!siteModel.getCustomer().getAddress().contains(a)) {
			siteModel.getCustomer().addAddress(a);
		}
		return "order";
	}
}
