/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javax.faces.convert;

import Technicals.Id.SingleIdEntity;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

/**
 *
 * @author Florian
 */
public abstract class AbstractConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null) {
			return "";
		}

		SingleIdEntity entity = find(Long.valueOf(value));

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
	
	public abstract SingleIdEntity find(Long l);

}
