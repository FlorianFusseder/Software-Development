/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javax.faces.convert;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

/**
 *
 * @author Florian
 */
public interface Converter {
	
	public Object getAsObject(FacesContext context, UIComponent component, String value);
	
	public String getAsString(FacesContext context, UIComponent component, Object value);
}
