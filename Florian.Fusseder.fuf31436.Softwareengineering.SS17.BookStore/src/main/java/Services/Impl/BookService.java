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
import java.util.stream.Collectors;
import javax.enterprise.context.RequestScoped;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author Florian
 */
@RequestScoped
@WebService
public class BookService implements IBookService {

	@Inject
	private AbstractBookRepo bookManager;

	@Inject
	private PersonRepo personManager;

	public BookService() {
	}

	@WebMethod(exclude = true)
	@Transactional(Transactional.TxType.REQUIRED)
	public AbstractBook merge(AbstractBook abstractBook) {
		return bookManager.merge(abstractBook);
	}

	@WebMethod(exclude = true)
	@Transactional(Transactional.TxType.REQUIRED)
	public Author persistNewBook(AbstractBook b, Author author) {
		List<Author> newList = new ArrayList<>();
		newList.add(author);
		persistNewBook(b, newList);
		return newList.get(0);
	}

	@WebMethod(exclude = true)
	@Transactional(Transactional.TxType.REQUIRED)
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
	public AbstractBook find(AbstractBook book) {
		return bookManager.findById(book.getID());
	}

	@WebMethod(exclude = true)
	public AbstractBook find(String Id) {
		return bookManager.findById(Id);
	}
	
	public List<AbstractBook> findAll() {
		return bookManager.findAll();
	}

	public List<AbstractBook> searchBooks(String term) {

		String s = "SELECT B FROM AbstractBook AS B WHERE ";
		s = s.concat(Arrays.asList(term.split(" ")).stream()
				.map(str -> "LOWER(B.name) LIKE '%" + str.toLowerCase() + "%'")
				.collect(Collectors.joining(" OR ")));

		return bookManager.createQuery(s).getResultList();
	}
}
