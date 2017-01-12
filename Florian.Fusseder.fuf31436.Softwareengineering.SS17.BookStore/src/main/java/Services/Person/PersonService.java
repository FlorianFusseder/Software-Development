/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Person;

import Entitys.Address;
import Entitys.Person;
import Services.Interfaces.IPersonService;
import Technicals.Repo.BankRepo;
import Technicals.Repo.PersonRepo;
import Technicals.Repo.ShoppingCartRepo;
import javax.inject.Inject;
import javax.transaction.Transactional;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 *
 * @author Florian
 */
@NoArgsConstructor
public abstract class PersonService<T extends Person> implements IPersonService<T> {

	@Inject
	@Getter(AccessLevel.PROTECTED)
	private PersonRepo personRepo;

	@Inject
	@Getter(AccessLevel.PROTECTED)
	private BankRepo bankRepo;

	@Inject
	@Getter(AccessLevel.PROTECTED)
	private ShoppingCartRepo shoppingCartRepo;
	

	@Transactional(Transactional.TxType.REQUIRED)
	@Override
	public T addAddress(T person, Address address) {
		person = (T) this.personRepo.merge(person);
		person.addAddress(address);
		return person;
	}

}
