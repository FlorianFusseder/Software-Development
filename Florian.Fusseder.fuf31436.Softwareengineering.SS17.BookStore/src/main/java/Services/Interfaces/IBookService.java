/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Interfaces;

import Entitys.AbstractBook;
import Entitys.Author;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Florian
 */
public interface IBookService extends Serializable {

	public AbstractBook merge(AbstractBook abstractBook);

	public Author persistNewBook(AbstractBook b, Author author);

	public List<Author> persistNewBook(AbstractBook b, List<Author> author);

	public AbstractBook find(AbstractBook book);

	public AbstractBook find(String Id);

	public List<AbstractBook> findAll();

	public List<AbstractBook> searchBooks(String term);
}
