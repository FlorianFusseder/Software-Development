/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Entitys.Address;
import java.util.List;
import javax.annotation.PostConstruct;
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
public class ChooseDeliveryAdressModel {

	@Inject
	private ShoppingSiteModel siteModel;

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
	private List<Address> addresses;

	@Getter
	@Setter
	private Address choosenAddress;

	@PostConstruct
	private void init() {
		this.newCity = "";
		this.newStreet = "";
		this.newPostNumber = null;
		this.addresses = siteModel.getCustomer().getAddress();
	}

	public String setDeliveryAddress() {

		Address a = null;

		if (!this.newCity.isEmpty()) {
			a = new Address(this.newStreet, this.newCity, this.newPostNumber);
		} else {
			a = choosenAddress;
		}

		siteModel.getShoppingCart().setDeliveryAddress(a);
		if (!siteModel.getCustomer().getAddress().contains(a)) {
			siteModel.getCustomer().addAddress(a);
		}
		return "order";
	}
}
