/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entitys.AbstractBook;
import Entitys.Author;
import Technicals.Repo.AbstractBookRepo;
import Technicals.Repo.PersonRepo;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Florian
 */
@RequestScoped
public class BookService implements Serializable {

	@Inject
	private AbstractBookRepo bookManager;

	@Inject
	private PersonRepo personManager;

	public BookService() {
	}

	@Transactional(Transactional.TxType.REQUIRED)
	public Author persistNewBook(AbstractBook b, Author author) {
		bookManager.persist(b);
		author = (Author) personManager.merge(author);
		b.addAuthor(author);
		author.addBook(b);
		return author;
	}

	@Transactional(Transactional.TxType.REQUIRED)
	public List<Author> persistNewBook(AbstractBook b, List<Author> author) {
		List<Author> newList = new ArrayList<>();

		for (Author a : author) {
			b = bookManager.merge(b);
			a = (Author) personManager.merge(a);
			b.addAuthor(a);
			a.addBook(b);
			newList.add(a);
		}

		return newList;
	}

	public AbstractBook findByObject(AbstractBook book) {
		return bookManager.findById(book.getID());
	}

	public AbstractBook findById(String Id) {
		return bookManager.findById(Id);
	}

	public List<AbstractBook> findAll() {
		return bookManager.findAll();
	}

}
