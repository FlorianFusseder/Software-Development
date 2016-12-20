/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javax.faces.convert;

import Annotations.PersonAnnotation;
import Entitys.IEntity;
import Services.Interfaces.IFindable;
import Technicals.Id.SingleIdEntity;
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
public class ConverterIMPL implements Converter {

	@Inject
	@PersonAnnotation
	private IFindable manager;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null) {
			return "";
		}

		SingleIdEntity entity = (SingleIdEntity) manager.find(Long.valueOf(value));

		if (entity == null) {
			return "";
		}
		return entity;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null) {
			return null;
		}

		String s = ((SingleIdEntity) value).getID().toString();
		return s;
	}

}
