/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javax.faces.convert;

import Technicals.Id.SingleIdEntity;
import Technicals.Repo.PersonRepo;
import javax.enterprise.context.RequestScoped;
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
public class PersonConverter extends AbstractConverter{
	
	@Inject
	private PersonRepo personService;

	@Override
	public SingleIdEntity find(Long l) {
		return this.personService.findById(l);
	}
}
