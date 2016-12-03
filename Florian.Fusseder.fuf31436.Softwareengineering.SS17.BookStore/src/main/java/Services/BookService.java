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
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Florian
 */
@RequestScoped
public class BookService implements Serializable {

	@Inject
	private AbstractBookRepo BookManager;

	@Inject
	private PersonRepo personManager;

	public BookService() {
	}

	@Transactional(Transactional.TxType.REQUIRED)
	public Author persistNewBook(AbstractBook b, Author a) {
		BookManager.persist(b);
		a = (Author) personManager.merge(a);
		b.addAuthor(a);
		a.addBook(b);
		return a;
	}

	public AbstractBook findByObject(AbstractBook book) {
		return BookManager.findById(book.getID());
	}
	
	public AbstractBook findById(String Id){
		return BookManager.findById(Id);
	}

	public List<AbstractBook> findAll() {
		return BookManager.findAll();
	}

}
