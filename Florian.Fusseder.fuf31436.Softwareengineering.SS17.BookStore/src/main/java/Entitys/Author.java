/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Represents an Author
 *
 * @author Florian
 */
@Entity
@Table(name = "author")
public class Author extends Person
{

    private long sold;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<AbstractBook> books;

    /**
     * Creates an Author with empty fields but initializeses a empty books List
     */
    public Author()
    {
        this.books = new ArrayList<>();
    }

    /**
     * Creates an Author with given Fieldes and a empty books List
     *
     * @param firstName Firstname
     * @param lastName Lastname
     * @param adress Adress Object
     * @param sold Number of sold books from this Author
     */
    public Author(String firstName, String lastName, Adress adress, long sold)
    {
        super(firstName, lastName, adress);
        this.sold = sold;
        this.books = new ArrayList<>();
    }

    /**
     * Creates an Author with given Fieldes
     *
     * @param firstName
     * @param lastName
     * @param adress
     * @param sold amount of sold books
     * @param books
     */
    public Author(String firstName, String lastName, Adress adress, long sold, List<AbstractBook> books)
    {
        super(firstName, lastName, adress);
        this.sold = sold;
        this.books = books;
    }

    public long getSold()
    {
        return sold;
    }

    public void setSold(long sold)
    {
        this.sold = sold;
    }

    /**
     * Increase the sold books of the author by given number
     *
     * @param sold Amount of sold books
     */
    public void increaseSold(long sold)
    {
        this.sold += sold;
    }

    public List<AbstractBook> getBooks()
    {
        return Collections.unmodifiableList(books);
    }

    public void setBooks(List<AbstractBook> books)
    {
        this.books = books;
    }

    public void addBook(AbstractBook book)
    {
        this.books.add(book);
    }

    @Override
    public String toString()
    {
        return super.toString() + " Author{" + "sold=" + sold + ", books=" + books + '}';
    }
}
