/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Person;

import Annotations.AuthorAnnotation;
import Entitys.Author;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import lombok.NoArgsConstructor;

/**
 *
 * @author Florian
 */
@AuthorAnnotation
@RequestScoped
@NoArgsConstructor
public class AuthorService extends PersonService<Author> {

	@Inject
	private Logger logger;

	@Transactional(Transactional.TxType.REQUIRED)
	@Override
	public List<Author> findAll() {
		logger.info("Find all Authors");
		return this.getPersonRepo().findAll().stream()
				.filter(p -> p.getClass() == Author.class)
				.map(p -> (Author) p)
				.collect(Collectors.toList());
	}

	@Transactional(Transactional.TxType.REQUIRED)
	@Override
	public Author create(Author person) {
		logger.info("Create an Author");
		this.getPersonRepo().persist(person);
		return person;
	}
}
