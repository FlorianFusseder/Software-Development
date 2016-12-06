/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javax.faces.convert;

import Entitys.Customer;
import Services.PersonService;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.NoArgsConstructor;

/**
 *
 * @author Florian
 */
@Named
@RequestScoped
@NoArgsConstructor
public class CustomerConverter implements Converter{

	@Inject
	private PersonService personManager;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value == null)
			return "";
		
		Customer customer = (Customer) personManager.find(Long.valueOf(value));
		
		if(customer == null)
			return "";
		return customer;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value == null)
			return null;
		if(!value.getClass().equals(Customer.class))
			return null;
		String s = ((Customer) value).getID().toString();
		return s;
	}
	
}
