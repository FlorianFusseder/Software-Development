/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Impl;

import Entitys.AbstractBook;
import Entitys.Author;
import Services.Interfaces.IBookService;
import Technicals.Repo.AbstractBookRepo;
import Technicals.Repo.PersonRepo;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.enterprise.context.RequestScoped;
import javax.jws.WebMethod;
import javax.jws.WebService;
import lombok.NoArgsConstructor;

/**
 *
 * @author Florian
 */
@RequestScoped
@WebService
@NoArgsConstructor
public class BookService implements IBookService {
	
	@Inject
	private Logger logger;

	@Inject
	private AbstractBookRepo bookManager;

	@Inject
	private PersonRepo personManager;

	@WebMethod(exclude = true)
	@Transactional(Transactional.TxType.REQUIRED)
	@Override
	public Author persistNewBook(AbstractBook b, Author author) {
		logger.info("persistNewBook BookService");
		List<Author> newList = new ArrayList<>();
		newList.add(author);
		persistNewBook(b, newList);
		return newList.get(0);
	}

	@WebMethod(exclude = true)
	@Transactional(Transactional.TxType.REQUIRED)
	@Override
	public List<Author> persistNewBook(AbstractBook b, List<Author> author) {
		List<Author> newList = new ArrayList<>();

		for (Author a : author) {
			a = (Author) personManager.findById(a.getID());
			bookManager.persist(b);
			a = (Author) personManager.merge(a);
			b.addAuthor(a);
			a.addBook(b);
			newList.add(a);
		}
		return newList;
	}

	@WebMethod(exclude = true)
	@Override
	public AbstractBook find(AbstractBook book) {
		logger.info("Search for book " + book.getName());
		return bookManager.findById(book.getID());
	}

	@Override
	public List<AbstractBook> findAll() {
		logger.info("Search for all Books");
		return bookManager.findAll();
	}

	@Override
	public List<AbstractBook> searchBooks(String term) {
		
		logger.info("Search for books with following terms: " + term);

		String s = "SELECT B FROM AbstractBook AS B WHERE ";
		s = s.concat(Arrays.asList(term.split(" ")).stream()
				.map(str -> "LOWER(B.name) LIKE '%" + str.toLowerCase() + "%'")
				.collect(Collectors.joining(" OR ")));

		return bookManager.createQuery(s).getResultList();
	}
}
